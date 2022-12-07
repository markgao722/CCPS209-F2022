package Working;

import org.junit.Test;
import java.util.Iterator;
import java.util.Random;
import java.util.zip.CRC32;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class RewindIteratorTest {

    @Test public void testFirst1000() {
        // Change false to true to see what your iterator generates.
        massTest(50, 876040768L);
    }

    @Test public void testFirstMillion() {
        massTest(1_000_000, 1839975941L);
    }

    @Test public void testFirstHundredMillion() {
        massTest(100_000_000, 2819947101L);
    }

    private void massTest(int n, long expected) {
        CRC32 check = new CRC32();
        Random rng = new Random(4444);
        Iterator<Integer> ints = new Iterator<>() {
            int v = 0;

            public boolean hasNext() {
                return true;
            }

            public Integer next() {
                return v++;
            }
        };
        RewindIterator<Integer> rwi = new RewindIterator<>(ints);
        rwi.getInfo();
        int marks = 0, count = 0, prev = -1;
        for(int i = 0; i < n; i++) {
            int v = rwi.next();
            rwi.getInfo();
            if(prev != -1) {
                // If no rewind took place last round, elements must increase by one.
                System.out.println("Prev+1 ="+(prev+1)+", v ="+v);
                assertEquals(prev + 1, v);
            }
            prev = v;
            count++;
            check.update(v);
            if(rng.nextInt(100 + i) < 20 || (marks == 0 && count > 10 + i / 10)) {
                System.out.println("Mark---");
                rwi.mark();
                marks++;
                count = 0;
                rwi.getInfo();
                System.out.println("-----");
            }
            if(marks > 0 && rng.nextInt(100 + i) < 30) {
                System.out.println("Rewind---");
                rwi.rewind();
                marks--;
                prev = -1;
                rwi.getInfo();
                System.out.println("-----");
            }
        }
        assertEquals(expected, check.getValue());
        while(marks-- > 0) { rwi.rewind(); }
        try { rwi.rewind(); } catch(IllegalStateException e) { return; }
        // If this line is reached, your rewind method does not fail as specified.
        fail();
    }

    @Test public void customTest() {
        // New iterator
        Iterator<Integer> ints = new Iterator<>() {
            int v = 0;

            public boolean hasNext() {
                return true;
            }

            public Integer next() {
                return ++v;
            }
        };
        // New rewindable iterator
        RewindIterator<Integer> rwints = new RewindIterator<>(ints);
        rwints.getInfo();

        int s1 = rwints.next();
        rwints.getInfo();

        rwints.mark();
        rwints.getInfo();

        int s2 = rwints.next();
        rwints.getInfo();

        rwints.mark();
        rwints.getInfo();

        int s3 = rwints.next();
        rwints.getInfo();

        rwints.rewind();
        rwints.getInfo();

        int s4 = rwints.next();
        rwints.getInfo();

    }
}


/*
        int s1 = rwints.next();
        rwints.getInfo();

        rwints.mark();
        rwints.getInfo();

        int s2 = rwints.next();
        rwints.getInfo();

        rwints.mark();
        rwints.getInfo();

        int s3 = rwints.next();
        rwints.getInfo();

        rwints.rewind();
        rwints.getInfo();

        int s20 = rwints.next();
        rwints.getInfo();

        int s30 = rwints.next();
        rwints.getInfo();

        rwints.rewind();
        rwints.getInfo();

        int s21 = rwints.next();
        rwints.getInfo();

        int s31 = rwints.next();
        rwints.getInfo();
 */