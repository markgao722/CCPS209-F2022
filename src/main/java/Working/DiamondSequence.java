package Working;

import java.util.Iterator;
import static java.lang.Math.toIntExact;

public class DiamondSequence implements Iterator<Integer> {
    /* Summary: The NatSet library is a kind of Set<E> used to track the natural numbers.
        Use this to create the Diamond Sequence, an infinite sequence starting with a1 = 1.
        The next element a(k) = the smallest new positive integer such that the first k elements of the
            sequence sum to an integer multiple of k.
        Example: [1,3,2,6,8,4,11,5,14,16,7,19,21,9,...]
        hrs: 2
     */

    public boolean hasNext() { return true; }

    private Long k = 0L; //the sequence generated thus far
    private Long sum = 0L;  // sum of the sequence generated thus far
    private final NatSet seen = new NatSet();  // integers seen so far in the sequence generated thus far
    // [0,1,2,3,4,5,6,7,...]
    // [T,T,T,F,F,F,F,F,...]

    /**
     * Returns the next integer in the Diamond Sequence (see definition). Each instance is a new sequence.
     * @return Returns the next integer in the sequence
     */
    public Integer next() {
        //Q1 is conversion to Integer last minute ok?
        //Q2 do we represent number 1 in the zero idx position?
        long testVal;
        this.k++;

        // check for smallest unseen integer I, if it satisfies sum+I % k == 0 use it, if not, keep looking
        testVal = seen.allTrueUpTo() + 1L;
        while(this.sum + testVal % this.k != 0) {
            testVal += 1;
        }
        sum += testVal;
        seen.add(testVal);
        return toIntExact(testVal);
    }
}
