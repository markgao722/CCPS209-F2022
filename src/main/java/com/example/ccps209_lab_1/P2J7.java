package com.example.ccps209_lab_1;

public class P2J7 {
    /* Summary: Practice working with ArrayList, by implementing a double-ended queue (deque) with it.
        This deque is represented in the problem as a circle of people lining up.
        The "josephus strategy" involves starting at position k and eliminating that person, then,
        starting from the next available person, counting k steps again.
        If k > size, start counting from the start of the line as the line is a circle.
        hrs: 0
     */

    /**
     *
     * @param men The lineup of men in the order they stand
     * @param k The starting position for elimination, as well as the step size
     * @return Return a list of men in the order in which they were eliminated
     * @param <T> Men, or some other type as the method does not depend on element type
     */
    public static <T> List<T> josephus(List<T> men, int k) {

    }

    /**
     * Distribute a total of <seats> seats to each of the states in the array population.
     * Each state gets at least one seat.
     * Every next seat is allocated to the state with the highest "priority quantity", that is
     *  P^2 / (s (s+1)) where P is the state's population, and s is its existing seat allocation.
     * @param population A collection of states, whose elements are their populations
     * @param seats Total number of seats to distribute
     * @return
     */
    public static int[] huntingtonHill(int[] population, int seats) {

    }
}
