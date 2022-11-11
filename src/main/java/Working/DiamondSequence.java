package Working;

import java.util.Iterator;
import java.lang.Math;

public class DiamondSequence implements Iterator<Integer> {
    /* Summary: The NatSet library is a kind of Set<E> used to track the natural numbers.
        Use this to create the Diamond Sequence, an infinite sequence starting with a1 = 1.
        The next element a(k) = the smallest new positive integer such that the first k elements of the
            sequence sum to an integer multiple of k.
        Example: [1,3,2,6,8,4,11,5,14,16,7,19,21,9,...]
        hrs: 0
     */

    public boolean hasNext() { return true; }

    private Long k = 0L;  // current position of the sequence generated thus far
    private Long sum = 0L;  // sum of the sequence generated thus far
    private NatSet seen = new NatSet();  // integers seen so far in the sequence generated thus far

    /**
     * Returns the next integer in the Diamond Sequence (see definition). Each instance is a new sequence.
     * @return Returns the next integer in the sequence
     */
    public Integer next() {
        Integer nextVal = 1;
        this.k++;

        for(int i = Math.toIntExact(this.k); i < this.k; i++) {
            
        }

        return nextVal;
    }
}
