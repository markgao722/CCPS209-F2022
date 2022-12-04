package Working;

import java.util.Arrays;

public class Polynomial {
    /* Summary:
        hrs: 1
     */
    private final int[] coeff;
    private int deg = 0;

    // Lab 1: constructor, getDegree, getCoefficient, evaluate
    public Polynomial(int[] coefficients) {
        // A polynomial 5X^3 - 7X + 42
        // Will have array [42,-7,0,5]
        coeff = Arrays.copyOf(coefficients, coefficients.length);

        for (int i = coefficients.length - 1; i >= 0; i--) {
            if (coefficients[i] != 0) {
                deg = i;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "";
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

    }

    public Polynomial multiply(Polynomial other) {
        
    }
}
