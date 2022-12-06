package Working;

public class StringRope extends Rope {
    /*
        Part 1 of 3 of Rope I lab
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
}
