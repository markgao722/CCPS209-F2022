package temporary;

import java.math.BigInteger;

public class P2J8 {
    /* Summary: Two integer manipulation samples for practicing Java syntax.
        hrs:
     */

    /**
     * Find the lowest exponents, p1, p2, for the integers a, b such that the difference
     * t*(b**p2 - a**p1) is smaller than the smaller number of the pair, a1**p1.
     * @param a The base of the first number
     * @param b The base of the second number
     * @param t The tolerance, to be multiplied to the difference of numbers
     * @param out Input the resulting exponents p1, p2 to the supplied output container
     */
    public static void hittingIntegerPowers(int a, int b, int t, int[] out) {
        throw new UnsupportedOperationException();
    }

    /**
     * Find an integer from the s-gonal sequence that is closest to the number n.
     * Where tied between two s-gonal numbers, take the lower.
     * An s-gonal sequence is given by the formula Sn = ((s-2)i**2 - (s-4)i) /2, all with S1 = 1.
     * @param n The number to find "in" the sequence
     * @param s The type of sequence to search in
     * @return Return a number from the s-gonal sequence closest to n
     */
    public static BigInteger nearestPolygonalNumber(BigInteger n, int s) {
        // Use a binary search to move markers i, j, until they envelope n, then compare which to use as the answer.
        throw new UnsupportedOperationException();
    }
}
