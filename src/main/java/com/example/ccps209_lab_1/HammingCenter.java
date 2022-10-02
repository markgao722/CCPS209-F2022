package com.example.ccps209_lab_1;

public class HammingCenter {
    /* Summary: the Hamming Distance between two arrays is the number of positions in which they differ.
        The Hamming Center, for a set of boolean arrays, is a boolean array with Hamming Distance <= r, from all
        those arrays. r is a parameter set by the function caller.
        For the set of arrays a={0,0}, b={1,1}, the Hamming Center can be either {0,1} or {1,0}. Recall 1 = True.
            Notice r = 1 in this case, as the array {0,1} differs from the a, b by at most 1.
        hrs: 0
     */

    /**
     * Calls findCenter to find the Hamming Center for the given arrays in bits. bits itself is an array of arrays.
     * The solution is a boolean array whose Hamming Distance is at most r from the arrays in bits.
     * The solution should be the lexicographically lowest solution, e.g. where false precedes true.
     * @param bits An array of boolean arrays, which have the same length
     * @param r The maximum radius of the Hamming Center
     * @return Return the Hamming Center array, or null if no solution exists for bits and r
     */
    public static boolean[] findHammingCenter(boolean[][] bits, int r) {
        boolean[] hamCenter;

        return hamCenter;
    }

    /**
     * Helper method for findHammingCenter.
     * @param bits An array of boolean arrays, which have the same length
     * @param distance An array of integers who count how many elements in the i-th center differ from bits[i]
     * @param center The current iteration's (i) Hamming Center solution
     * @param k The current element in the current Hamming Center solution, from 0 to center.length
     * @param r The maximum radius of the Hamming Center
     * @return
     */
    private static boolean findCenter(boolean[][] bits, int[] distance, boolean[] center, int k, int r) {

        return false;
    }
}
