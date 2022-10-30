package com.example.ccps209_lab_1;

import java.util.ArrayList;

public class AccessCountArrayList<E> extends ArrayList<E> {
    /* Summary: this class should extend ArrayList to implement some basic functionality, that being:
        - Overridden get/set methods increment count then call the superclass equivalent method.
        - Additional features to interact with the count (combined total of get and set calls).
        hrs: 1
     */

    int count = 0;

    /**
     * Increments count then does the same thing as ArrayList.get().
     * @param index Index of the element to return
     * @return The element at index
     */
    @Override
    public E get(int index) {
        this.count++;
        return super.get(index);
    }

    /**
     * Increments count then does the same thing as ArrayList.set().
     * @param index Index of the element to be replaced
     * @param element Element to place at the index
     * @return The replaced element
     */
    @Override
    public E set(int index, E element) {
        this.count++;
        return super.set(index, element);
    }

    public int getAccessCount() {
        return this.count;
    }

    public void resetCount() {
        this.count = 0;
    }
}
