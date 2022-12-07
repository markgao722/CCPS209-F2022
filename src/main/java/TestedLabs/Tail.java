package TestedLabs;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Tail extends FileProcessor<List<String>> {
    /* Summary: Practice file I/O with the BufferedReader class, as well as abstract class
        implementation (see Fileprocessor.java)
        hrs: 2
     */

    private int linesToReturn;
    private LinkedList<String> lines;
    private int totalLines;  // WARNING: "totalLines" in the test file refers to multiple runs of processFile

    // Constructor
    public Tail (int n) {
        linesToReturn = n;
        lines = new LinkedList<>();
        totalLines = 0;
    }

    @Override
    protected void startFile() {
        // Nothing to do
    }

    /**
     * Allows FileProcess.processFile to behave like Unix command: tail,
     * which returns the last n lines of its text input.
     * @param line A line of text
     */
    @Override
    protected void processLine(String line) {
        lines.add(line);
        totalLines++;
    }

    // Customer function for debugging
    protected void getLines() {
        for (String l: lines) {
            System.out.println("NEWLINE || "+l);
        }
    }

    /**
     * Give a List<String> (probably a LinkedList) that contains the n most recent lines
     * given to processLine, in the same order that method was called. If fewer lines than n
     * were given to processLine, just give all lines passed to processLine.
     * @return A list of lines
     */
    @Override
    protected List<String> endFile() {
        LinkedList<String> popped = new LinkedList<>();  // popped will be in the opposite of desired order

        // Can't return more lines than were processed
        if(linesToReturn > totalLines) { linesToReturn = totalLines; }

        // pop from the end and reverse the results
        for (int i = 1; i <= linesToReturn; i++) {
            String p = lines.removeLast();
            popped.add(p);
        }

        Collections.reverse(popped);

        return popped;
    }
}
