package FirstDraft;

import java.util.Arrays;

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

        // binary search
        while (left < right) {
            if (a[x_idx] < x) {
                left = x_idx;
            } else if (a[x_idx] > x) {
                right = x_idx;
            } else {
                break; // x was in the middle
            }
            x_idx = (right - left - 1) / 2;
        }
        System.out.println(x_idx);

        // k closest elements
        int[] result = new int[k];  // [0,1,2,3,...k]
        int i = 0;  // steps away from x_idx being observed
        int p = 0; // idx of next free spot in results

        if (k > 0) { result[p] = a[x_idx]; p++; i++; }
        System.out.println(Arrays.toString(result));

        int left_idx = Math.max(x_idx - 1, 0);
        int right_idx = Math.min(x_idx + 1, a.length-1);
        while (p  < k) {
            int left_value = a[left_idx];
            int right_value = a[right_idx];

            int preferred_value;
            if(Math.abs(left_value - a[x_idx]) < Math.abs(right_value - a[x_idx])) {
                preferred_value = left_value;
                left_idx = Math.max(left_idx--, 0);  // condition this to be "not usable" after zero
            } else if (Math.abs(left_value - a[x_idx]) > Math.abs(right_value - a[x_idx])) {
                preferred_value = right_value;
                right_idx = Math.min(right_value + 1, a.length-1);  // condition this to be "not usable after max
            } else {
                preferred_value = Math.min(left_value, right_value);
                if(left_value < right_value) { left_idx = Math.max(left_idx--, 0); }
                else { right_idx = Math.min(right_value + 1, a.length-1); }
            }

            result[p] = preferred_value;
            p++;

            System.out.println(Arrays.toString(result));
        }

        Arrays.sort(result);
        System.out.println(Arrays.toString(result));
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