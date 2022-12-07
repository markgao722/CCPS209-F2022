package TestedLabs;

public class P2J10 {
    /* Summary: Simple working with arrays and integers to practice the concept of dissimilarity measures.
        hrs: <1
     */

    public static Fraction matchingDissimilarity(boolean[] v1, boolean[] v2) {
        int[] ns = getMatches(v1, v2);
        int n01 = ns[1];
        int n10 = ns[2];

        Fraction F = new Fraction((n01+n10), v1.length);
        return F;
    }

    public static Fraction jaccardDissimilarity(boolean[] v1, boolean[] v2) {
        int [] ns = getMatches(v1, v2);
        int n01 = ns[1];
        int n10 = ns[2];
        int n11 = ns[3];

        Fraction F = new Fraction((n01+n10), (n11+n01+n10));
        return F;
    }

    public static Fraction diceDissimilarity(boolean[] v1, boolean[] v2) {
        int [] ns = getMatches(v1, v2);
        int n01 = ns[1];
        int n10 = ns[2];
        int n11 = ns[3];

        Fraction F = new Fraction((n01+n10), (2*n11+n01+n10));
        return F;
    }

    public static Fraction rogersTanimonoDissimilarity(boolean[] v1, boolean[] v2) {
        int [] ns = getMatches(v1, v2);
        int n00 = ns[0];
        int n01 = ns[1];
        int n10 = ns[2];
        int n11 = ns[3];

        Fraction F = new Fraction(2*(n01+n10), (n11 + 2*(n01+n10) + n00));
        return F;
    }

    public static Fraction russellRaoDissimilarity(boolean[] v1, boolean[] v2) {
        int [] ns = getMatches(v1, v2);
        int n00 = ns[0];
        int n01 = ns[1];
        int n10 = ns[2];

        Fraction F = new Fraction((n01+n10+n00), v1.length);
        return F;
    }

    public static Fraction sokalSneathDissimilarity(boolean[] v1, boolean[] v2) {
        int [] ns = getMatches(v1, v2);
        int n01 = ns[1];
        int n10 = ns[2];
        int n11 = ns[3];

        Fraction F = new Fraction(2*(n01+n10), (n11 + 2*(n01+n10)));
        return F;
    }

    /**
     * Get the n_00, n_01, n_10, n_11 counts for the two vectors v1 and v2. Length of v1, v2 assumed equal.
     * n_00: number of positions where both vectors are false
     * n_01: number of positions where v1 is false, v2 is true
     * n_10: number of positions where v1 is true, v2 is false
     * n_11: number of positions where both vectors are true
     * @param v1 The first vector
     * @param v2 The second vector
     * @return An array containing the n_00, n_01, n_10, n_11 counts, in that order
     */
    private static int[] getMatches(boolean[] v1, boolean[] v2) {
        int n00 = 0;
        int n01 = 0;
        int n10 = 0;
        int n11 = 0;

        for (int i = 0; i < v1.length; i++) {
            if(v1[i] == v2[i]) {
                if(v1[i]) { n11++; }
                else { n00++; }
            } else {
                if(v1[i]) { n10++; }
                else { n01++; }
            }
        }

        int[] ns = new int[4];
        ns[0] = n00;
        ns[1] = n01;
        ns[2] = n10;
        ns[3] = n11;
        return ns;
    }
}
