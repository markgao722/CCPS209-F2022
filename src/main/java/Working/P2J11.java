package Working;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;

public class P2J11  {

    public static List<Integer> buildSuffixArray(String text) {
        // all substrings from full text down to last letter of text,
        // to be represented by number i of letters taken from the front 0 to text.length()-1
        TreeMap<String, Integer> map = new TreeMap<>();
        // substring: i
        // Treemap automatically sorted by key when putting

        for(int i = 0; i < text.length(); i++) {
            String suf = text.substring(i, text.length());
            System.out.println(suf);
            map.put(suf, i);
        }

        // Extract treemap values (the i's) and convert to List
        Collection<Integer> setValues = map.values();
        ArrayList<Integer> colValues = new ArrayList<>(setValues);

        return colValues;
    }

    // "hello" sorted suffixes are:
    // "ello"   1
    // "hello"  0
    // "llo"    2  <- found l%
    // "lo"     3  <- found l%
    // "o"      4

    public static List<Integer> find(String pattern, String text, List<Integer> suffix) {
        // binary search to find the idx that is <= the pattern
        int idx = suffix.size() / 2;
        throw new UnsupportedOperationException();
    }
}
