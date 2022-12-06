package Tested;

import java.util.Arrays;
import java.util.Objects;

public class Polynomial implements Comparable<Polynomial> {
    /* Summary:
        hrs: 3
     */

    // A polynomial 5X^3 - 7X + 42
    // Will have array [42,-7,0,5]
    private final int[] coeff;
    private int deg = 0;

    // Lab 1: constructor, getDegree, getCoefficient, evaluate
    public Polynomial(int[] coefficients) {
        // Remove redundant zeros from the right (and increment degree)
        // NOTE: {0} is valid and represents zero
        int copyTo = coefficients.length - 1;
        while(coefficients[copyTo] == 0 && copyTo > 0) {
            copyTo--;
        }
        coeff = Arrays.copyOf(coefficients, copyTo + 1);
        deg = coeff.length - 1;
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < deg; i++) {
            s = s + getCoefficient(i) + "x^" + i + " ";
        }
        return s;
    }

    public int getDegree() {
        return deg;
    }

    public int getCoefficient(int k) {
        if (k < 0 || k > deg) { return 0; }
        else { return coeff[k]; }
    }

    public long evaluate(int x) {
        long base = x;  // store X^d-1 so that X^d = X^d-1 * X
        long sum = 0;
        long constant = coeff[0];

        for (int k = 1; k <= deg; k++) {
            sum += coeff[k] * base;
            base = base * x;
        }
        return sum + constant;
    }

    // Lab 2: add, multiply
    public Polynomial add(Polynomial other) {
        // Determine whether this or other is the higher degree
        int lowerDeg = Math.min(this.deg, other.deg);
        int higherDeg = Math.max(this.deg, other.deg);
        boolean thisIsHigher = true;
        boolean thisIsEqual = false;

        if(this.deg < other.deg) {
            thisIsHigher = false;
        } else if( this.deg == other.deg) {
            thisIsEqual = true;
        }

        // If degrees unequal, add zeros to shorter polynomial. Skip if degree equal
        int[] thisCoeff = new int[higherDeg + 1];
        int[] otherCoeff = new int[higherDeg + 1];
        if(!thisIsEqual && thisIsHigher) {
            thisCoeff = this.coeff;
            for(int i = 0; i <= higherDeg; i++) {
                if(i <= lowerDeg) { otherCoeff[i] = other.coeff[i]; }
                else { otherCoeff[i] = 0; }
            }
        } else if (!thisIsEqual && !thisIsHigher) {
            otherCoeff = other.coeff;
            for(int i = 0; i <= higherDeg; i++) {
                if(i <= lowerDeg) { thisCoeff[i] = this.coeff[i]; }
                else { thisCoeff[i] = 0; }
            }
        } else {
            thisCoeff = this.coeff;
            otherCoeff = other.coeff;
        }

        // Add coefficients and generate answer.
        int[] sums = new int[higherDeg + 1];

        for(int i = 0; i <= higherDeg; i++) {
            sums[i] = thisCoeff[i] + otherCoeff[i];
        }

        Polynomial result = new Polynomial(sums);
        return result;
    }

    public Polynomial multiply(Polynomial other) {
        // The result array should fit the product of the highest degree terms in this and other
        int[] products = new int[this.getDegree() + other.getDegree() + 1];

        // Loop through all possible products. Skip any a*0 or b*0 operations
        // Note: if thisCoeff degree 3 (4 elements) x otherCoeff degree 3 (4 elements), there are 4^4 steps

        for(int i = 0; i < this.coeff.length; i++) {
            // Use i to remember what degree a is

            for(int j = 0; j < other.coeff.length; j++) {
                // Use j to remember what degree b is
                int product = this.coeff[i] * other.coeff[j];
                int productDeg = i + j;
                if(product == 0) { continue; }

                products[productDeg] += product;
            }
        }

        Polynomial result = new Polynomial(products);
        return result;
    }

    // Lab 3: equals, hashCode, compareTo


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polynomial that = (Polynomial) o;
        return deg == that.deg && Arrays.equals(coeff, that.coeff);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(deg);
        result = 31 * result + Arrays.hashCode(coeff);
        return result;
    }

    public int compareTo(Polynomial other) {
        if(this.deg > other.deg) { return 1; }
        else if (this.deg < other.deg) { return -1; }
        else {
            // next highest degree term wins based on coefficient
            for(int n = this.deg; n >= 0; n--) {
                if(this.coeff[n] > other.coeff[n]) { return 1; }
                else if(this.coeff[n] < other.coeff[n]) { return -1; }
            }
            return 0;
        }
    }
}
