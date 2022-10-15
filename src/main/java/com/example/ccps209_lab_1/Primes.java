package com.example.ccps209_lab_1;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

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
    }

    /**
     * Get the k-th prime number from the infinite sequence of prime numbers.
     * @param k A positive position
     * @return The k-th prime number
     */
    public static int kthPrime(int k) {

    }

    /**
     * Get the prime factors of n, sorted in ascending order. Each factor appears as many times as it is multiplied
     * to get the product.
     * @param n The integer to factor
     * @return Returns a list of integer prime factors
     */
    public static List<Integer> factorize(int n) {

    }

    // Use a private instance of ArrayList<Integer> to store already discovered primes, sorted ascending.
    // This ArrayList is helpful to kthPrime and isPrime.

    // Use Collections.binarySearch() to quickly determine whether an integer is prime by searching the ArrayList.

    // Use a private helper expandPrimes() to append to the ArrayList, as/when needed by isPrime and kthPrime.
}
