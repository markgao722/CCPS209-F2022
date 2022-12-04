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
        int lowerDeg = Math.min(this.deg, other.deg);
        int higherDeg = Math.max(this.deg, other.deg);
        boolean thisIsHigher = true;
        if(this.deg < other.deg) { thisIsHigher = false; }
        System.out.println("High d:"+higherDeg+" lower d:"+lowerDeg);

        // Ensure two coefficient arrays equal size
        int[] newcoeffs = new int[higherDeg + 1];
        for(int i = 0; i < higherDeg + 1; i++) {
            if(thisIsHigher) {
                newcoeffs[i] = other.getCoefficient(i);  // newcoeffs represents other
            } else {
                newcoeffs[i] = this.getCoefficient(i);  // newcoeffs represents this
            }
        }
        //TEST
        Polynomial N = new Polynomial(newcoeffs);
        System.out.println("New polynomial: " +N);

        // Loop over arrays and add
        int[] sums = new int[higherDeg];
        for(int i = 0; i < higherDeg; i++) {
            if(thisIsHigher) {
                sums[i] = this.getCoefficient(i) + newcoeffs[i];
            } else {
                sums[i] = newcoeffs[i] + other.getCoefficient(i);
            }
        }

        // Check for new leading degree-zeros before creating the result polynomial
        Polynomial result = new Polynomial(sums);
        System.out.println("Result polynomial: " +result);
        return result;
    }

    public Polynomial multiply(Polynomial other) {
        throw new UnsupportedOperationException();
    }
}
