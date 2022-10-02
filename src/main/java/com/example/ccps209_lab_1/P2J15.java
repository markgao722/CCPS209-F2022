package com.example.ccps209_lab_1;
import java.util.Arrays;
import java.lang.Math;

public class P2J15 {
    /* Summary: the generalized two-pointers method is a while loop that increments an array index i, and decrements
        an array index j, until either the target value is found or the indices pass each other indicating no solution.
        At each change in i/j value it should be 100% certain that a possible solution cannot be accidentally
        crossed (when moving in steps larger than 1).
        hrs: 4
     */

    /**
     * The array a contains k or more distinct integers sorted ascending, and the target value x.
     * This method returns an array of k elements closest to x within the array, using the binary search method.
     * @param a The array of integers containing x
     * @param x The target value to find
     * @param k The number of elements to fetch from a
     * @return Return the array of k (integer) elements closest to x, sorted ascending
     */
    public static int[] findClosestElements(int[] a, int x, int k) {
        // binary search
        int x_idx;
        int left;
        int right;
        left = 0;
        x_idx = a.length / 2;  // assume all inputs' length = size
        right = a.length;

        while (left < right) {
            if (a[x_idx] < x) {
                left = x_idx;
            } else if (a[x_idx] > x) {
                right = x_idx;
            } else {
                break; // x was in the middle
            }
            x_idx = (right - left) / 2;
        }

        // k closest elements
        int[] result = new int[k];
        int i = 0;  // i+1 is the number of elements currently stored in the result array
        while (i + 1 < k) {
            int left_item = a[x_idx - 1];
            int right_item = a[x_idx + 1];
            if (k - result.length < 2) {
                result[i] = Math.min(left_item, right);
            } else {
                result[i] = left_item;
                result[i + 1] = right_item;
                i++;
            }
            i++;
        }

        Arrays.sort(result);
        return result;
    }

    /**
     * The array a contains positive integers and is not sorted. This method returns the number of contiguous
     * sub-arrays that add up to sum, including singular elements who equal sum.
     * @param a The array of integers
     * @param sum The value which the sub-arrays must sum to
     * @return Return the number of sub-arrays (int)
     */
    public static int countSubarraysWithSum(int[] a, int sum) {
        int results = 0;
        int i = 0;
        int j = 0;
        int sum_to_here;
        while (j < a.length) {
            // check the sub-array's sum
            int[] slice = Arrays.copyOfRange(a, i, j);
            sum_to_here = Arrays.stream(slice).sum();

            if (sum_to_here < sum) { j++; }
            else if (sum_to_here > sum) { i++; }
            else {
                j++;
                results++;
            }
        }

        return results;
    }
}