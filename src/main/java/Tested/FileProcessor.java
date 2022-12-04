package Tested;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class FileProcessor<R> {
    /* For the WordCount lab */

    protected abstract void startFile();
    protected abstract void processLine(String line);
    protected abstract R endFile();

    public final R processFile(BufferedReader in) throws IOException {
        startFile();
        String ln = in.readLine();
        int c = 0;
        while(ln != null) {
            processLine(ln);
            ln = in.readLine();
        }
        // The last, empty line is being detected as null so force it to process ""
        processLine("");
        return endFile();
    }
}
