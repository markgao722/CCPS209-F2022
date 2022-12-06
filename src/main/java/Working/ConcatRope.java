package Working;

public class ConcatRope extends Rope {
    /*
        Part 2 of 3 of Rope I lab
     */
    private final Rope left;
    private final Rope right;

    // constructor
    public ConcatRope(Rope left, Rope right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public char charAt(int index) {
        if(index < 0 || index > left.length() + right.length() + 1) { throw new IndexOutOfBoundsException(); }
        if(index > left.length() - 1) {
            return right.charAt(index - left.length());
        } else {
            return left.charAt(index);
        }
    }

    @Override
    protected int computeLength() {
        return left.length() + right.length();
    }

    @Override
    public String toString() {
        return left.toString() + right.toString();
    }
}
