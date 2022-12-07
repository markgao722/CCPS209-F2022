package TestedLabs;

import java.util.ArrayList;
import java.util.List;

public class WordCount extends FileProcessor<List<Integer>> {
    /* Summary: Practice file I/O with the BufferedReader class, as well as abstract
        implementation (see Fileprocessor.java)
        hrs: <1 hr
     */
    private int characters;
    private int words;
    private int lines;

    /**
     * Initializes the instance variables to zero
     */
    @Override
    protected void startFile() {
        characters = 0;
        words = 0;
        lines = 0;
    }

    /**
     * Detect the number of characters, words, lines in the line of text.
     * Every character counts as 1, including whitespace.
     * Every word is separated by 1 or more whitespace characters.
     * @param line A line of text produced by BufferedReader.readLine()
     */
    @Override
    protected void processLine(String line) {
        boolean lastLineWS = true;  // pretend first line always starts with whitespace

        for(int i = 0; i < line.length(); i++) {
            characters++;

            char c = line.charAt(i);

            // new word: non-WS when previously WS
            if(lastLineWS && !Character.isWhitespace(c)) {
                words++;
                lastLineWS = false;
            }

            // end of word: WS when previously non-WS
            if(!lastLineWS && Character.isWhitespace(c)) { lastLineWS = true; }

            // continue WS / continue word: do nothing
        }
        lines++;
    }

    /**
     * Returns an ArrayList of character, word, line counts
     * @return An ArrayList containing the counts
     */
    @Override
    protected List<Integer> endFile() {
        ArrayList<Integer> counts = new ArrayList<>();
        counts.add(characters);
        counts.add(words);
        counts.add(lines);

        return counts;
    }
}
