package Working;

import java.util.Iterator;
import static java.lang.Math.toIntExact;

public class DiamondSequence implements Iterator<Integer> {
    /* Summary: The NatSet library is a kind of Set<E> used to track the natural numbers.
        Use this to create the Diamond Sequence, an infinite sequence starting with a1 = 1.
        The next element a(k) = the smallest new positive integer such that the first k elements of the
            sequence sum to an integer multiple of k.
        Example: [1,3,2,6,8,4,11,5,14,16,7,19,21,9,...]
        hrs: 4
     */

    public boolean hasNext() { return true; }

    private Long k = 0L; //the sequence generated thus far
    private Long sum = 0L;  // sum of the sequence generated thus far
    private NatSet seen = new NatSet();  // integers seen so far in the sequence generated thus far
        // [0,1,2,3,4,5,6,7,8,...]
        // [T,T,F,F,F,F,F,F,F,...]

    // Constructor helps ensure the 1 index actually represents the number 1
    public DiamondSequence() { this.seen.add(0); }

    /**
     * Returns the next integer in the Diamond Sequence (see definition). Each instance is a new sequence.
     * @return Returns the next integer in the sequence
     */
    public Integer next() {
        // check for smallest unseen integer I, if it satisfies sum+I % k == 0 use it, if not, keep looking
        long smallestInt;
        this.k++;

        smallestInt = this.seen.allTrueUpTo(); // Note: method allTrueUpTo gives idx of next FALSE position

        while((this.sum + smallestInt) % this.k != 0) {  // is this method too slow to pass 1,000,000 k....??
            smallestInt += 1L;
        }

        this.sum += smallestInt;
        this.seen.add(smallestInt);
        return toIntExact(smallestInt);
    }
}
