package com.example.ccps209_lab_1;

import java.math.BigInteger;

public class P2J8 {
    /* Summary: Two integer manipulation samples for practicing Java syntax.
        hrs: 1
     */

    /**
     * Find the lowest exponents, p1, p2, for the integers a, b such that the absolute difference
     * t*(b**p2 - a**p1) is smaller than the smaller number of the pair, a1**p1.
     * @param a The base of the first number
     * @param b The base of the second number
     * @param t The tolerance, to be multiplied to the difference of numbers
     * @param out Input the resulting exponents p1, p2 to the supplied output container
     */
    public static void hittingIntegerPowers(int a, int b, int t, int[] out) {
        int p1 = 1;
        int p2 = 1;
        BigInteger ap = new BigInteger(String.valueOf(Math.pow(a, p1)));
        BigInteger bp = new BigInteger(String.valueOf(Math.pow(b, p2)));
        BigInteger bigT = new BigInteger(String.valueOf(t));
        BigInteger diff = bigT.multiply(bp.subtract(ap)).abs();

        BigInteger bigA = new BigInteger(String.valueOf(a));
        BigInteger bigB = new BigInteger(String.valueOf(b));
        while(diff.compareTo(ap.min(bp)) != -1) {  // difference must be SMALLER than the smaller number
            ap = ap.multiply(bigA);
            bp = bp.multiply(bigB);
            p1++;
            p2++;
        }

        out[0] = p1;
        out[1] = p2;
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
