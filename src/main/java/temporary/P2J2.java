package temporary;

public class P2J2 {
    /* Summary: A sampling of string and array operations to practice Java syntax.
        hrs:
     */

    /**
     * Remove contiguous duplicate characters in the given string, treating capitalization as different characters.
     * Duplicates are allowed where the characters are separated by other characters, e.g. "aaAAAaaxxx" should be
     * transformed to "aAax"
     * @param text The string to remove duplicates from
     * @return Return the string with contiguous duplicates removed
     */
    public static String removeDuplicates(String text) {
        throw new UnsupportedOperationException();
    }

    /**
     * Remove all duplicate characters in the given string, treating capitalization as different characters.
     * E.g. "Kokkarinen" should be transformed to "Kokarine"
     * @param text The string to remove duplicates from
     * @return Return the string with duplicates removed
     */
    public static String uniqueCharacters(String text) {
        // Try to use a HashSet<Character> instead of nested for loops.
        throw new UnsupportedOperationException();
    }

    /**
     * Count how many tiles on an n x n chessboard are "safe" from the rooks placed on the board.
     * Rooks are marked on the n x n board as a 2D boolean array with true indicating a rook.
     * @param n The number of rows/columns on the square, nxn chessboard
     * @param rooks The positions of the rooks, marked as true
     * @return Return the count of tiles that are "safe" from the rooks
     */
    public static int countSafeSquaresRooks(int n, boolean[][] rooks) {
        throw new UnsupportedOperationException();
    }

    /**
     * Return the nth term of Recaman's sequence, where the first term A1 = 1 and:
     *  An = A_{n-1} - n if the new number is new and > 0.
     *  An = A_{n-1} + n if the number has been seen before.
     *  Example: for [A1,A2,A3,A4,A5,A6,A7,A8] the numbers are [1,3,6,2,7,13,20,12]
     * @param n
     * @return
     */
    public static int recaman(int n) {
        // Use a boolean[] to keep track of seen integers, so you can access them in constant time.
        throw new UnsupportedOperationException();
    }
}
