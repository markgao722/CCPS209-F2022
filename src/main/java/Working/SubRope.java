package Working;

import java.util.Objects;

public class SubRope extends Rope{
    /*
        Part 3 of 3 of Rope I lab
     */
    private Rope original;
    private int start;
    private int end;

    // constructor (start inclusive, end exclusive)
    public SubRope(Rope original, int start, int end) {
        if(start < 0 || start > end) { throw new IndexOutOfBoundsException(); }
        this.original = original;
        this.start = start;
        this.end = end;
    }

    @Override
    public char charAt(int index) {
        if(index < 0 || index > end - start - 1) { throw new IndexOutOfBoundsException(); }
        return original.charAt(start + index);
    }

    @Override
    protected int computeLength() {
        return end - start;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i = start; i < end; i++) {
            result.append(original.charAt(i));
        }
        return result.toString();
    }

    // Lab 2
    // Note: abstract class made to implement Comparable<Rope> as part of lab 2
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubRope subRope = (SubRope) o;
        return start == subRope.start && end == subRope.end && original.equals(subRope.original);
    }

    @Override
    public int hashCode() {
        return Objects.hash(original, start, end);
    }

}
