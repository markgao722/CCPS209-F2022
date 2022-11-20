package Working;

import java.util.Iterator;
import java.util.HashMap;
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

    private int k = 0; //the sequence generated thus far
    private Long sum = 0L;  // sum of the sequence generated thus far
    private NatSet seen = new NatSet();  // integers seen so far in the sequence generated thus far
        // [0,1,2,3,4,5,6,7,8,...]
        // [T,T,T,T,F,F,T,F,F,...]
    private HashMap<Integer,Integer> positions = new HashMap();  // NatSet number: k-position
        // [0,1,3,2,6,8,4,11,5,...]

    // Constructor helps ensure the 1 index actually represents the number 1
    public DiamondSequence() { this.seen.add(0); }

    /**
     * Returns the next integer in the Diamond Sequence (see definition). Each instance is a new sequence.
     * @return Returns the next integer in the sequence
     */
    public Integer next() {
        // Check for smallest unseen integer I, if it satisfies sum+I % k == 0 use it, if not, keep looking
        long smallestInt;
        this.k++;

        // Check for self-reference, otherwise search through all integers starting from lowest
        if(this.seen.contains(k)) {
            smallestInt = this.positions.get(k);
        } else {
            smallestInt = this.seen.allTrueUpTo(); // Note: method allTrueUpTo gives idx of next FALSE position

            while((this.sum + smallestInt) % this.k != 0) {  // 1M k = 8 minutes
                smallestInt += 1L;
            }
        }

        this.sum += smallestInt;
        this.seen.add(smallestInt);
        System.out.println("k: " + this.k + " value: " + smallestInt);

        positions.put(toIntExact(smallestInt), k);
        return toIntExact(smallestInt);
    }
}
