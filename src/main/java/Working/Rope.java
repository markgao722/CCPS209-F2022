package Working;

abstract public class Rope {
    abstract public char charAt(int index);
    private int len = -1;

    public final int length() {
        if(len == -1) {
            // Call the template method to initialize len.
            len = computeLength();
        }
        // Either way, we can now return the cached value.
        return len;
    }
    // Subclasses must override the actual length computation.
    abstract protected int computeLength();

    // Mentioned by lab but never needed
    /*
    public final Rope concatenate(Rope other) {
        return new ConcatRope(this, other);
    }
     */
}
