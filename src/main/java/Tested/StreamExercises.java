package Tested;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExercises {
    /* Summary: Practice using the Stream<T> class. Do not use if/switch/for/while statements.
        hrs: 1
     */

    public static int countLines(Path path, int thres) throws IOException {
        // Convert Path object to a Stream<String> object
        Stream<String> sStream = Files.lines(path);

        // Filter the Stream<String> object for lines whose length >= thresh
        Predicate<String> greq = l -> (l.length() >= thres);
        Stream<String> sFiltered = sStream.filter(greq);

        // Return count of lines whose length >= thresh
        return (int) sFiltered.count();
    }

    public static List<String> collectWords(Path path) throws IOException {
        // Convert Path object to a Stream<String> object
        Stream<String> sStream = Files.lines(path);

        // Convert each line to lowercase
        Stream<String> sLowered = sStream.map(String::toLowerCase);

        // Break lines into a Stream<String> of words; use "[^a-z]+" in the split method
        Stream<String> sWords = sLowered.flatMap(l -> Stream.of(l.split("[^a-z]+")));

        // Discard empty elements aka "empty" words in sWords + discard non-unique words
        Predicate<String> nonEmpty = w -> (w.length() > 0);
        Stream<String> sNonEmpty = sWords.filter(nonEmpty);
        Stream<String> sUnique = sNonEmpty.distinct();

        // Sort remaining words alphabetically, then return the results as a List<String>
        Stream<String> sSorted = sUnique.sorted();
        return sSorted.collect(Collectors.toList());
    }
}
