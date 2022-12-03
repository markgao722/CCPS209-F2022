package com.example.ccps209_lab_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Primes {
    /* Summary: A variety of basic operations to work with prime numbers.
        hrs: 1
     */

    // Use a private instance of ArrayList<Integer> to store already discovered primes, sorted ascending.
    // This ArrayList is helpful to kthPrime and isPrime.
    private static ArrayList<Integer> discoveredPrimes = new ArrayList<>();

    // Use a private helper expandPrimes() to append to the ArrayList, as/when needed by isPrime and kthPrime.
    private static void expandPrimes(int n) {
        if(discoveredPrimes.size() == 0) { discoveredPrimes.add(n); }
        if(n > discoveredPrimes.get(discoveredPrimes.size()-1)) {
            discoveredPrimes.add(n);
            discoveredPrimes.sort(Comparator.naturalOrder());
        }
    }

    /**
     * Checks whether the integer n is a prime number.
     * @param n The integer to check
     * @return Returns True if n is prime
     */
    public static boolean isPrime(int n) {
        // Trial division: if n has a nontrivial factor, one of them must be <= sqrt(n), so
        //  there's no need to check for factors greater than sqrt(n).
        if (n < 2) { return false; }
        if (n == 2) { return true; }

        int i = 2;
        while (i <= (int) Math.ceil(Math.sqrt(n))) {
            if(n % i == 0) { return false; }
            i++;
        }

        expandPrimes(n);
        return true;
    }

    /**
     * Get the k-th prime number from the infinite sequence of prime numbers.
     * @param k A positive position
     * @return The k-th prime number
     */
    public static int kthPrime(int k) {
        int i = 0;
        int curr = 1;

        // the prime numbers are 2,3,5,7...
        if (k == 0) { return 2; }
        if (k == 1) { return 3; }

        while (i < k) {
            curr += 2;
            if(isPrime(curr)) { i++; }
        }

        return curr;
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



    // Use Collections.binarySearch() to quickly determine whether an integer is prime by searching the ArrayList.


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
