package working;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.HashMap;
import java.lang.Math;

public class P2J4 {
    /* Summary: Practice using a variety of List operations on a list of integers.
        hrs: 5
     */

    /**
     * Return a new list whose first two elements are the same as the original, and each element thereafter is
     * the median of the trailing three elements (from the original list).
     * @param items The list of integers to find the median of
     * @return Return a list of integers representing medians
     */
    public static List<Integer> runningMedianOfThree(List<Integer> items) {
        List<Integer> result = new ArrayList<>();
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
        median = Math.max(Math.min(a,b), Math.min(Math.max(a,b),c));
        return median;
    }

    /**
     * Return an integer that is the first positive integer missing from the original list.
     * @param items An unsorted list of integers
     * @return Return the first (smallest) positive integer missing from items
     */
    public static int firstMissingPositive(List<Integer> items) {
        // Pigeonhole principle: smallest positive integer missing from list of n is n+1
        int n = items.size();
        Boolean[] seen = new Boolean[n];  // default is false

        // Track which integers have been seen using boolean array
        for (int i=0; i < n; i++) {
            int num = items.get(i);

            if (num <= n + 1) { seen[num - 1] = true; }
        }

        // Find the first false value in tracker array
        int result = 0;
        for (int j=0; j < n+1; j++) {
            if (seen[j] = false) { result = j + 1; }
        }

        return result;
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
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int k: items) {
            if (freq.containsKey(k)) {
                freq.put(k, freq.get(k) + 1);
            } else {
                freq.put(k, 1);
            }
        }

        // Create a subclass implementing Comparator<Integer> whose .compare() consults the map
        class FreqSorter implements Comparator<Integer> {

            @Override
            public int compare(Integer a, Integer b) {
                int first = a;
                if (freq.get(a) < freq.get(b)) { first = b; }
                else if (freq.get(a) == freq.get(b) && b < a) { first = b; }

                return first;
            }
        }

        // Sort in-place
        FreqSorter customComparator = new FreqSorter();
        items.sort(customComparator);
    }

    /**
     * Return a list of prime factors of n!. This list should be sorted in ascending order, and
     * each prime factor should appear as many times as needed to equal n!.
     * @param n An integer whose factorial will be n!
     * @return Return a sorted list of prime factors
     */
    public static List<Integer> factorFactorial(int n) {
        // Build list of prime factors while counting up to n instead of computing n! outright
        ArrayList<Integer> factors = new ArrayList<>();

        for(int m=n; m > 1; m--) {
            for(int i=2; i < m; i++) {
                while(m % i == 0) {
                    factors.add(i);
                    m = m / i;
                }
            }
        }

        factors.sort(Comparator.naturalOrder());
        return factors;
    }
}