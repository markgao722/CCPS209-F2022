package Working;

import java.util.Iterator;
import java.util.LinkedList;

public class RewindIterator<E> implements Iterator<E> {
    /* Summary: Decorate the Iterator<E> class so that it can be "rewound" to a previously saved position.
        hrs: 2
     */

    private Iterator<E> it;
    private LinkedList<E> buffer = new LinkedList<E>();
    private LinkedList<E> emitted = new LinkedList<E>();
    private LinkedList<Integer> markPositions = new LinkedList<>();
    private int pos = 0;
    // Confirm behaviour:
    // Upon instantiating a RewindIterator<E>:
    // - The object has position 0
    // - The next integer is 0
    // - The emitted list is empty
    // - This position is markable as 0, and rewinding to it will produce 1
    // By the end of the first next() call:
    // - The object has position 1
    // - The next integer is 2
    // - The emitted list is empty (technically: 1)

    // Constructor
    public RewindIterator(Iterator<E> it) { this.it = it;}

    @Override
    public boolean hasNext() {
        return it.hasNext() || !buffer.isEmpty();
    }

    @Override
    public E next() {
        pos++;

        if(!buffer.isEmpty()) {
            return buffer.removeFirst();
        } else {
            E nextItem = it.next();

            // If there are outstanding marks, push to emitted as well
            if(!markPositions.isEmpty()) { emitted.add(nextItem); }
            return  nextItem;
        }
    }

    // New methods

    /**
     * Marks the element so that the iterator can rewind to this position.
     * Multiple marks can be set before a rewind, and they can be set for the same position.
     * Let emitted contain the elements iterated by it, and
     * let buffer contain the elements retraced upon calling rewind. All elements in buffer
     * must be iterated through before emitted takes on new values (e.g. it returns to "original" position).
     */
    public void mark() {
        markPositions.add(pos);
        this.next();  // WARNING: next() returns
    }

    /**
     * Rewinds to the most recent mark.
     * @throws IllegalStateException Throw an exception if rewound with no active marks
     */
    public void rewind() throws IllegalStateException {
        int rewindTo = markPositions.removeLast();  // idx from which next() will be called
        int lastEmitted = emitted.size() - 1;  // idx of last item in emitted

        for(int i = 0; i < lastEmitted - rewindTo; i++) {
            buffer.addFirst(emitted.get(lastEmitted - i));
        }

        pos = rewindTo;
        this.next();
    }

    // For testing only
    public void getInfo() {
        String em = ""; String bf = ""; String mk = "";

        for(E e: emitted) { em += e.toString(); em += ","; }
        for(E b: buffer) { bf += b.toString(); bf += ",";}
        for(Integer m: markPositions) { mk += m.toString(); mk += ",";}

        System.out.println("Pos: " +pos+ "| Buffer: " +bf+ " | Marks: " +mk+ " | Emitted: " +em);
    }
}
