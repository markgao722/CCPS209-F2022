package com.example.ccps209_lab_1;
import java.util.Iterator;

public class PrimeGens {
    /* Summary:
        hrs: 0
     */


    public static class TwinPrimes implements Iterator<Integer> {

    }

    public static class SafePrimes implements Iterator<Integer> {

    }

    public static class StrongPrimes implements Iterator<Integer> {

    }

    // Example classes

    /*

    public static class PalindromicPrimes implements Iterator<Integer> {
        private int k = 0; // Current position in the prime sequence
        public boolean hasNext() { return true; } // Infinite sequence
        public Integer next() {
            while(true) {
                int p = Primes.kthPrime(k++);
                String digits = "" + p;
                if(digits.equals(new StringBuilder(digits).reverse().toString())) {
                    return p;
                }
            }
        }
    }

     */

    /*

    public static class Composites implements Iterator<Integer> {
        private int curr = 4, k = 2, nextPrime = Primes.kthPrime(2);
        public boolean hasNext() { return true; }
        public Integer next() {
            if(curr == nextPrime) {
                nextPrime = Primes.kthPrime(++k);
                curr++;
            }
            return curr++;
        }
    }

     */
}
