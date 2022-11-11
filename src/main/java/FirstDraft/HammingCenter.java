package FirstDraft;

import java.util.Arrays;

public class HammingCenter {
    /* Summary: the Hamming Distance between two arrays is the number of positions in which they differ.
        The Hamming Center, for a set of boolean arrays, is a boolean array with Hamming Distance <= r, from all
        those arrays. r is a parameter set by the function caller.
        For the set of arrays a={0,0}, b={1,1}, the Hamming Center can be either {0,1} or {1,0}. Recall 1 = True.
            Notice r = 1 in this case, as the array {0,1} differs from the a, b by at most 1.
        hrs: 4
     */

    /**
     * Calls findCenter to find the Hamming Center for the given arrays in bits. bits itself is an array of arrays.
     * The solution is a boolean array whose Hamming Distance is at most r from the arrays in bits.
     * The solution should be the lexicographically lowest solution, e.g. where false precedes true.
     * @param bits An array of boolean arrays, which have the same length
     * @param r The maximum radius of the Hamming Center
     * @return Return the Hamming Center array, or null if no solution exists for these bits and r
     */
    public static boolean[] findHammingCenter(boolean[][] bits, int r) {
        int n = bits.length;
        int m = bits[0].length;

        boolean[] center = new boolean[n];  // the Hamming Center solution
        int[] distance = new int[m];  // Hamming distances of each array between bits[i] and center
        int k = 0;

        while (k < n) {
            center[k]  = findCenter(bits, distance, center, k, r);

            int maxDist = Arrays.stream(distance).max().getAsInt();
            if (maxDist > r) { return null; }

            k++;
        }
        return center;
    }

    /**
     * Helper method for findHammingCenter. Finds the value of one element of the HammingCenter.
     * @param bits An array of boolean arrays, which have the same length
     * @param distance An array of integers who count how many elements in the i-th center differ from bits[i]
     * @param center The current iteration's (i) Hamming Center solution
     * @param k The current element in the current Hamming Center solution, from 0 to center.length
     * @param r The maximum radius of the Hamming Center
     * @return Return the value (T/F) that should be used in this k-th spot in the Hamming array
     */
    private static boolean findCenter(boolean[][] bits, int[] distance, boolean[] center, int k, int r) {
        int[] distancesIfFalse = Arrays.copyOf(distance, distance.length);
        int[] distancesIfTrue = Arrays.copyOf(distance, distance.length);

        for(int i = 0; i < bits.length; i++) {
            // Assume we first try center[k] as False; if bits[i][k] is True, +1 distance
            if (bits[i][k]) {
                distancesIfFalse[i]++;
            } else {
                distancesIfTrue[i]++;
            }
        }

        int falseGoodness;
        int trueGoodness;
        falseGoodness = Arrays.stream(distancesIfFalse).sum();
        trueGoodness = Arrays.stream(distancesIfTrue).sum();

        return falseGoodness >= trueGoodness;
    }
}