package com.example.ccps209_lab_1;

import java.util.Arrays;

public class P2J1 {
    /* Summary: A sampling of integer and array operations to practice Java syntax
        hrs: 1
     */

    /**
     * Calculate the "falling power" which is like a backwards factorial.
     * For the falling power 6^3, the calculation is equivalent to 6*5*4 = 120.
     * Negatives continue to be more negative (-1 each term) in a similar fashion.
     * @param n The base (any integer)
     * @param k The exponent (any non-negative integer)
     * @return Return the resulting long integer
     */
    public static long fallingPower(int n, int k) {
        // must use longs rather than ints throughout otherwise silent memory overflow will occur!
        long result = 1;
        int m = n;
        for (int i=k; i > 0; i--) {
            result = result * m;
            m--;
        }
        return result;
    }

    /**
     * Return only the elements in the even numbered indices from the original array.
     * @param arr The array from which to take elements
     * @return An array of elements whose indices were even in arr
     */
    public static int[] everyOther(int[] arr) {
        int[] messyresult = new int[arr.length];
        int r = 0;
        for(int i=0; i < arr.length; i++) {
            if(i % 2 == 0) {
                messyresult[r] = arr[i];
                r++;
            }
        }
        //Note: question states "no extra zeros hanging around at end of result array"
        int[] result = Arrays.copyOfRange(messyresult, 0, r);
        return result;
    }

    /**
     * Create a rows*cols matrix (2D array) of ascending integers starting from start.
     * Every odd-number indexed row (e.g. second row, idx=1) should have its integers sorted descending instead.
     * @param rows The number of rows in the matrix
     * @param cols The number of columns in the matrix
     * @param start The lowest integer in the matrix
     * @return Return a rows x cols matrix sorted per the instructions
     */
    public static int[][] createZigZag(int rows, int cols, int start){
        int[][] result = new int[rows][cols];
        int n = start;
        for(int i=0; i < rows; i++) {
            int[] rowArray = new int[cols];

            for(int j=0; j < cols; j++) {
                rowArray[j] = n;
                n++;
            }
            result[i] = rowArray;
        }

        // Reverse the odd-numbered rows
        for(int r=0; r < rows; r++) {
            if (r % 2 != 0) {
                int[] swapMe = result[r];

                for(int k = 0; k < swapMe.length / 2; k++) {
                    int temp = swapMe[k];
                    swapMe[k] = swapMe[swapMe.length - k - 1];
                    swapMe[swapMe.length - k - 1] = temp;
                }
                result[r] = swapMe;
            }
        }
        return result;
    }

    /**
     * An inversion is a pair of i,j such that i < j and arr[i] > arr[j].
     * Count the number of inversions in the array. An ascending array of n-elements has zero inversions.
     * A descending array has n(n-1)/2 inversions, the max possible number of inversions.
     * @param arr The array to count inversions from
     * @return Return the number of i,j pairs (i.e. inversions)
     */
    public static int countInversions(int[] arr) {
        int counter = 0;
        for(int i=0; i < arr.length-1; i++) {
            for(int j=i; j < arr.length; j++) {
                System.out.println("Comparing " + arr[i] + " to " + arr[j]);
                if(arr[i] > arr[j]) { counter++; }
            }
        }
        return counter;
    }
}
