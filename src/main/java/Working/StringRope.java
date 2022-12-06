package Working;

import java.util.Objects;

public class StringRope extends Rope {
    /*
        Part 1 of 3 of Rope I & II lab
     */
    private String s;

    // constructor
    public StringRope(String s) {
        this.s = s;
    }

    @Override
    public char charAt(int index) {
        if(index < 0 || index > s.length() - 1) { throw new IndexOutOfBoundsException(); }
        return s.charAt(index);
    }

    @Override
    protected int computeLength() {
        return s.length();
    }

    @Override
    public String toString() {
        return s;
    }

    // Lab 2
    // Note: abstract class made to implement Comparable<Rope> as part of lab 2
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringRope that = (StringRope) o;
        return s.equals(that.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s);
    }

}
