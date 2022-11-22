package Tested;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class P2J2 {
    /* Summary: A sampling of string and array operations to practice Java syntax.
        hrs: 2
     */

    /**
     * Remove contiguous duplicate characters in the given string, treating capitalization as different characters.
     * Duplicates are allowed where the characters are separated by other characters, e.g. "aaAAAaaxxx" should be
     * transformed to "aAax"
     * @param text The string to remove duplicates from
     * @return Return the string with contiguous duplicates removed
     */
    public static String removeDuplicates(String text) {
        // Assumes no whitespace!
        ArrayList<String> txt = new ArrayList<>(Arrays.asList(text.split("")));
        String currentDub = txt.get(0);
        String result = currentDub;

        for(String c: txt) {

            if(!Objects.equals(c, currentDub)) {
                result = result + c;
                currentDub = c;
            }
        }
        return result;
    }

    /**
     * Remove all duplicate characters in the given string, treating capitalization as different characters.
     * E.g. "Kokkarinen" should be transformed to "Kokarine"
     * @param text The string to remove duplicates from
     * @return Return the string with duplicates removed
     */
    public static String uniqueCharacters(String text) {
        // Try to use a HashSet<Character> instead of nested for loops.
        // Assumes no whitespace!
        String result = "";
        ArrayList<String> txt = new ArrayList<>(Arrays.asList(text.split("")));
        HashSet<String> seen = new HashSet<>();
        for(String c: txt) {
            if(!seen.contains(c)) {
                seen.add(c);
                result = result + c;
            }
        }
        return result;
    }

    /**
     * Count how many tiles on an n x n chessboard are "safe" from the rooks placed on the board.
     * Rooks are marked on the n x n board as a 2D boolean array with true indicating a rook.
     * @param n The number of rows/columns on the square, nxn chessboard
     * @param rooks The positions of the rooks, marked as true
     * @return Return the count of tiles that are "safe" from the rooks
     */
    public static int countSafeSquaresRooks(int n, boolean[][] rooks) {
        HashSet<Integer> safeRows = new HashSet<>();
        HashSet<Integer> safeColumns = new HashSet<>();
        for(int k = 1; k <= n; k++) { safeRows.add(k); safeColumns.add(k); }

        // WARNING: row idx starts from 1!
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(rooks[i-1][j-1]) { safeRows.remove(i); safeColumns.remove(j); }
            }
        }
        return safeRows.size() * safeColumns.size();
    }

    /**
     * Return the nth term of Recaman's sequence, where the first term A1 = 1 and:
     *  An = A_{n-1} - n if the new number is new and > 0.
     *  An = A_{n-1} + n if the number has been seen before.
     *  Example: for [A1,A2,A3,A4,A5,A6,A7,A8] the numbers are [1,3,6,2,7,13,20,12]
     * @param n The nth term of the sequence to get
     * @return Return the value An
     */
    public static int recaman(int n) {
        // Use a boolean[] to keep track of seen integers, so you can access them in constant time.
        boolean[] seen = new boolean[10*n];
        int lastTerm = 1;
        int nthTerm = 1;

        if(n==1) { return nthTerm; }
        seen[1] = true;

        for(int k=2; k <= n; k++) {
            if(lastTerm - k > 0 && seen[lastTerm - k] != lastTerm - k > 0) {
                nthTerm = lastTerm - k;
                seen[lastTerm - k] = true;
            } else {
                nthTerm = lastTerm + k;
                seen[lastTerm + k] = true;
            }
            lastTerm = nthTerm;
            System.out.println("last: " + lastTerm + " n: " + nthTerm);
        }
        System.out.println("Answer - last: " + lastTerm + " n: " + nthTerm);
        return nthTerm;
    }
}
