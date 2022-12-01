package Working;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P2J3 {
    /* Summary: Array and integer manipulations to be tested with a text file.
        hrs: 1
     */

    /**
     * Rearrange the given array in-place, such that every portion that is strictly ascending
     * is reversed. Example: [9,6,7,8,1,3] -> [9,8,7,6,3,1]
     * A descending array remains unchanged. [5, 4, 3, 2, 1] -> [5, 4, 3, 2, 1]
     * @param items The array to sort
     */
    public static void reverseAscendingSubarrays(int[] items) {
        for (int i = 0; i < items.length - 1; i++) {
            if (items[i + 1] <= items[i]) { continue; }

            for (int j = i + 1; j < items.length; j++) {
                if (items[j + 1] <= items[j]) {
                    // Convert array to arraylist
                    int[] subarray = Arrays.copyOfRange(items, i, j);
                    IntStream subarraystream = Arrays.stream(subarray);
                    ArrayList<Integer> subarraylist = (ArrayList<Integer>) subarraystream.boxed().collect(Collectors.toList());

                    Collections.reverse(subarraylist);
                    int[] newsubarray = subarraylist.toArray();



                    i = j + 1;
                    break;
                }
            }
        }
    }

    /**
     * Continually reverse the string text, first by its first 2 characters, then 3,
     * then 4, ... then by the entire string.
     * @param text The string to rearrange
     * @return The reversed string
     */
    public static String pancakeScramble(String text) {
        // Reverse a StringBuilder object as there is no .reverse() on str types
        // Convert back after reversing via str = new StringBuilder(str).reverse().toString();
        throw new UnsupportedOperationException();
    }

    /**
     * Rearrange characters in text such that all vowels are reversed.
     * Only A,E,I,O,U and their lowercase equivalents are vowels.
     * Capitalization should be based off of the ending wording, not the starting.
     * Example: "Uncle Sammy" -> "Ancle Summy
     * @param text
     * @return
     */
    public static String reverseVowels(String text) {
        throw new UnsupportedOperationException();
    }
}
