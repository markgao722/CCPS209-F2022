package com.example.ccps209_lab_1;

import java.util.Arrays;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class P2J15 {
    /* Summary: the generalized two-pointers method is a while loop that increments an array index i, and decrements
        an array index j, until either the target value is found or the indices pass each other indicating no solution.
        At each change in i/j value it should be 100% certain that a possible solution cannot be accidentally
        crossed (when moving in steps larger than 1).
        hrs: 6
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

        // k closest elements
        int[] result = new int[k];  // result array [0,1,2,3,...k]
        int p = 0;  // tracker for next available position in result

        // prepare an array of distances from x
        int[] differences = new int[a.length];
        for(int h = 0; h < differences.length; h++) {
            differences[h] = Math.abs(x - a[h]);
        }

        // loop through distances until result array is full
        Integer i = x_idx;  // distances on left side of x
        Integer j = x_idx;  // distances on right side of x
        while(p < k) {
            i = max(i-1, 0);
            j = min(i+1, a.length);

            int e; // value to add in this iteration
            if(differences[i] < differences[j]) {
                e = differences[i];
                i = max(i - 1, 0);
            } else if(differences[i] > differences[j]) {
                e = differences[j];
                j = min(j + 1, a.length);
            } else if(i == null) {
                e = differences[j];
                j = min(j + 1, a.length);
            } else if(j == null) {
                e = differences[i];
                i = max(j - 1, 0);
            } else {  // differences[i] tie differences[j]; prefer the smaller value a[i], a[j]
                if(a[i] < a[j]) {
                    e = a[i];
                    i = max(i - 1, 0);
                } else {
                    e = a[j];
                    j = min(j + 1, a.length);
                }
            }
            result[p] = e;
            p++;
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
        int i;
        int j;

        for(i=0; i < a.length; i++) {
            for (j=i; j < a.length; j++) {  // Not the most efficient start point for j but oh well
                int[] slice = Arrays.copyOfRange(a, i, j+1);
                int s = Arrays.stream(slice).sum();
                System.out.println(s);
                if (s == sum) { results++; }
            }
        }

        // check the sub-array's sum
        // int[] slice = Arrays.copyOfRange(a, i, j);
        // sum_to_here = Arrays.stream(slice).sum();

        return results;
    }
}