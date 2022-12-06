package Working;

abstract public class Rope implements Comparable<Rope> {
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

    // Lab 2
    private int hash = -1;

    @Override
    public int compareTo(Rope o) {
        // If shorter rope is done, longer string is definitely lexographically smaller,
        // so loop over the smaller one first
        for(int i = 0; i < Math.min(this.length(), o.length()); i++) {
            if(this.charAt(i) > o.charAt(i)) { return 1; }
            else if(this.charAt(i) < o.charAt(i)) { return -1; }
        }
        // The short portion is the same...
        // If lengths were equal, the whole thing was the same
        if(this.length() == o.length()) { return 0; }
        else if(this.length() < o.length()) { return 1; }
        else { return -1; }
    }
}
