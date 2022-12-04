package Tested;

import java.io.IOException;
import java.io.Writer;
import java.util.function.BiPredicate;

public class FilterWriter extends Writer {
    /* Summary: Practice creating a decorator by working with the Writer class.
        hrs: <1hr
     */

    private Writer writer;
    private BiPredicate<Character, Character> pred;
    private char previous;

    // Constructor
    public FilterWriter(Writer writer, BiPredicate<Character, Character> pred, char previous) {
        this.writer = writer;
        this.pred = pred;
        this.previous = previous;
    }

    /**
     *
     * @param cbuf
     *         Array of characters
     *
     * @param off
     *         Offset from which to start writing characters
     *
     * @param len
     *         Number of characters to write
     *
     */
    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        for (int i = off; i < len; i++) {
            // If current character c passes the test, write c and let it become previous
            char c = cbuf[i];
            if(pred.test(previous, c)) {
                writer.write(c);
                previous = c;
            }
        }
    }

    // Override flush() and close() so they call the corresponding methods on underlying Writer
    @Override
    public void flush() throws IOException {
        writer.flush();
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}
