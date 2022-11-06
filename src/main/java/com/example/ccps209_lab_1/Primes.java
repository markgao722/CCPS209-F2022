package com.example.ccps209_lab_1;

import java.util.Iterator;
import java.util.List;

public class Primes {
    /* Summary: A variety of basic operations to work with prime numbers.
        hrs: 0
     */

    /**
     * Checks whether the integer n is a prime number.
     * @param n The integer to check
     * @return Returns True if n is prime
     */
    public static boolean isPrime(int n) {
        // Trial division: if n has a non-prime factor, one of them must be <= sqrt(n), so
        //  there's no need to check for factors greater than sqrt(n).
        return false;
    }

    /**
     * Get the k-th prime number from the infinite sequence of prime numbers.
     * @param k A positive position
     * @return The k-th prime number
     */
    public static int kthPrime(int k) {
        return 0;
    }

    /**
     * Get the prime factors of n, sorted in ascending order. Each factor appears as many times as it is multiplied
     * to get the product.
     * @param n The integer to factor
     * @return Returns a list of integer prime factors
     */
    public static List<Integer> factorize(int n) {
        return null;
    }

    // Use a private instance of ArrayList<Integer> to store already discovered primes, sorted ascending.
    // This ArrayList is helpful to kthPrime and isPrime.

    // Use Collections.binarySearch() to quickly determine whether an integer is prime by searching the ArrayList.

    // Use a private helper expandPrimes() to append to the ArrayList, as/when needed by isPrime and kthPrime.

    public class PrimeGens {
        /* Summary:
            Requires the methods isPrime and kthPrime from the Primes lab.
            hrs: 0
         */

        public class TwinPrimes implements Iterator<Integer> {
            private int a = 3;

            public boolean hasNext() { return true; }

            public Integer next() {
                return a;
            }

            // public void remove() has default behaviour
        }

        public class SafePrimes implements Iterator<Integer> {
            private int a = 5;

            public boolean hasNext() { return true; }

            public Integer next() {
                return a;
            }
        }

        public class StrongPrimes implements Iterator<Integer> {
            private int a = 11;

            public boolean hasNext() { return true; }

            public Integer next() {
                return a;
            }
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
}
