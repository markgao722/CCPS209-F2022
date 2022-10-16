package com.example.ccps209_lab_1;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class Manhattan {
    /* Summary: A demonstration of an implementation of the "sweep line algorithm". Assume we're looking at a skyline
        at night such that the silhouette of the buildings look like 2D rectangles, which may overlap because the
        buildings are close together. Do not double count the silhouette area in this case.
        hrs: 0
     */

    /**
     * Calculate the total area of the skyline's silhouette given the buildings as represented by the arrays
     * s, e, h, which have equal sizes and each k-th element refers to the start, end, and height coordinates of each
     * k-th building. Buildings may overlap in the silhouette, so their overlapped area should only be included once.
     * Assume s < e, and all of s, e, h are positive integers.
     * @param s An array of starting points of each silhouette
     * @param e An array of ending points of each silhouette
     * @param h An array of heights of each silhouette
     * @return Return the total area seen of the silhouette
     */
    public static int totalArea(int[] s, int[] e, int[] h) {
        // While sweeping from x-coordinates left to right, note all "interesting events"
        // In this case, events are when building x-coordinates enter/exit view
        List<Integer> events = new ArrayList<>();

        // Let the k-th building entering view be -1-k, and exiting view be k-1

        // Sort with a Comparator<Integer> which sorts ascending, first by their s then by their e

        // Keep track of all the buildings in "active view", which helps with double counting
        Set<Integer> active = new HashSet<>();

    }
}
