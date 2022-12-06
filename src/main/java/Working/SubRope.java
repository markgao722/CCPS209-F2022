package Working;

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
}
