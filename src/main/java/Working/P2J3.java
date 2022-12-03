package Working;

import java.util.ArrayList;
import java.util.HashSet;

import static java.lang.Character.isUpperCase;

public class P2J3 {
    /* Summary: Array and integer manipulations to be tested with a text file.
        hrs: 3
     */

    /**
     * Rearrange the given array in-place, such that every portion that is strictly ascending
     * is reversed. Example: [9,6,7,8,1,3] -> [9,8,7,6,3,1]
     * A descending array remains unchanged. [5, 4, 3, 2, 1] -> [5, 4, 3, 2, 1]
     * @param items The array to sort
     */
    public static void reverseAscendingSubarrays(int[] items) {
        for (int i = 0; i < items.length - 1; i++) {
            if (items[Math.min(i + 1, items.length - 1)] <= items[i]) {
                continue;
            }

            for (int j = i + 1; j < items.length; j++) {
                if (items[Math.min(j + 1, items.length - 1)] <= items[j]) {
                    int N = j - i;  //i=3, j=6, N=3

                    for (int n = 0; n < (N / 2) + 1 ; n++) {

                        int tmp = items[i + n];
                        items[i + n] = items[j - n];  // does this work for both odd and even N? Yes
                        items[j - n] = tmp;
                    }

                    i = j;
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
        StringBuilder textsb = new StringBuilder(text);

        for (int i = 2; i <= text.length(); i++) {
            String sub = textsb.substring(0, i);
            StringBuilder s = new StringBuilder(sub);
            s.reverse();

            textsb.replace(0, i, s.toString());
        }

        return textsb.toString();
    }

    /**
     * Rearrange characters in text such that all vowels are reversed.
     * Only A,E,I,O,U and their lowercase equivalents are vowels.
     * Capitalization should be based off of the ending wording, not the starting.
     * Example: "Uncle Sammy" -> "Ancle Summy
     * @param text The string to rearrange
     * @return The rearranged string
     */
    public static String reverseVowels(String text) {
        StringBuilder textsb = new StringBuilder(text);
        HashSet<String> vowel = new HashSet<>();
        vowel.add("a");
        vowel.add("e");
        vowel.add("i");
        vowel.add("o");
        vowel.add("u");

        ArrayList<Integer> capitals = new ArrayList<>();
        capitals.add(0);
        ArrayList<Integer> vowels = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            if (vowel.contains(textsb.substring(i,i+1).toLowerCase())) {
                vowels.add(i);
            }
            if (isUpperCase(textsb.charAt(i))) {
                capitals.add(i);
            }
        }

        int N = vowels.size();
        if (N == 0 ) { return text; }
        System.out.println("There are "+N+" vowels");

        for (int n = 0; n < (N / 2); n++) {
            System.out.println("n= "+n+" N-n="+(N-n-1));
            Character left = Character.toLowerCase(textsb.charAt(n));
            Character right = Character.toLowerCase(textsb.charAt(N - n - 1));
            System.out.println("left: "+left+" right: "+right);
            System.out.println("replacing "+textsb.substring(n,n+1)+ " with "+textsb.substring(N-n,N-n+1));
            textsb.replace(n,n+1, right.toString());
            textsb.replace(N-n,N-n+1, left.toString());
        }

        return textsb.toString();
    }
}
