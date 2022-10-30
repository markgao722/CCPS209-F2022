package com.example.ccps209_lab_1;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class P2J4 {
    /* Summary: Practice using a variety of List operations on a list of integers.
        hrs: 1
     */

    /**
     * Return a new list whose first two elements are the same as the original, and each element thereafter is
     * the median of the trailing three elements (from the original list).
     * @param items The list of integers to find the median of
     * @return Return a list of integers representing medians
     */
    public static List<Integer> runningMedianOfThree(List<Integer> items) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(items.get(0));
        result.add(items.get(1));

        for (int pos = 2; pos < items.size(); pos++) {
            int a = result.get(pos - 2);
            int b = result.get(pos - 1);
            int c = items.get(pos);
            int d = calcMedian(a, b, c);

            result.add(d);
        }
        return result;
    }

    // Custom helper to avoid clutter
    private static int calcMedian(int a, int b, int c) {
        int median;
        List<E> numbers = Arrays.asList(a, b, c);

        // array-backed list methods...?
        return median;
    }

    /**
     * Return an integer that is the first positive integer missing from the original list.
     * @param items An unsorted list of integers
     * @return Return the first (smallest) positive integer missing from items
     */
    public static int firstMissingPositive(List<Integer> items) {
        // Pigeonhole principle: first missing positive of a list of size n must be less than or equal n+1
        // Use a boolean array of size n+1 to track which numbers have been seen

        // Use 2 consecutive, rather than nested, for loops
    }

    /**
     * Sorts a list by the following criteria:
     *  1) decreasing order of frequency
     *  2) increasing order of values
     * These operations are done to the list in-place, so do not return anything.
     * @param items An unsorted list of integers
     */
    public static void sortByElementFrequency(List<Integer> items) {
        // Use a Map<Integer, Integer> to count how many times each value appears

        // Create a subclass implementing Comparator<Integer> whose .compare() consults the map
    }

    /**
     * Return a list of prime factors of n!. This list should be sorted in ascending order, and each prime factor
     * should appear as many times as needed to equal n!.
     * @param n An integer whose factorial will be n!
     * @return Return a sorted list of prime factors
     */
    public static List<Integer> factorFactorial(int n) {
        // Build list of prime factors while counting up to n instead of computing n! outright

        // Append to result list

        // Sort the result list
    }
}