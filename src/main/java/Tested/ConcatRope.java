package Tested;

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

    // Lab 2
    // Note: abstract class made to implement Comparable<Rope> as part of lab 2
    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConcatRope that = (ConcatRope) o;
        return left.equals(that.left) && right.equals(that.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
    */
}
