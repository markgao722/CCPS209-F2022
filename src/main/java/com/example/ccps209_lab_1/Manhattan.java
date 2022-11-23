package com.example.ccps209_lab_1;

import java.util.*;

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

        // Encode the k-th building entering view as -1-k, and exiting view as k-1
        for(int k = 1; k < s.length; k++) {
            events.add(-1-k);  // buildings entering view 1: -2, 2: -3, 3: -4,...
            events.add(k-1);  // buildings exiting view 1: 0, 2: 1, 3: 2,...
        }

        // Sort with a Comparator<Integer> which sorts ascending, first by their s then by their e
        class encodedSort implements Comparator<Integer> {

            @Override
            public int compare(Integer o1, Integer o2) {
                int beginLeft = -1 - o1;
                int exitLeft = o1 + 1;
                int beginRight = -1 -o2;
                int exitRight = o2 + 1;

                if(beginLeft < beginRight) { return -1; }
                else if(beginLeft > beginRight) { return 1; }
                else {
                    // are exact ties even allowed?? Only count active building.
                    return Integer.compare(exitLeft, exitRight);
                }
            }
        }
        encodedSort sorter = new encodedSort();
        events.sort(sorter);

        // Keep track of all the buildings in "active view", which helps with double counting
        Set<Integer> active = new HashSet<>();  // should this contain k or s ??
        int last_x = 0;
        int area = 0;

        for(int ev: events) {
            if(ev < 0) {
                // ENTER
                int i = -1 - ev -1;  // kth building less 1 is the idx of that building in s,h
                last_x = s[i];

                // Check if this building taller than last unfinished building
                if(h[i] < h[i+1]) {
                    // STOP
                } else {
                    // KEEP ADDING
                }
            } else {
                // EXIT
                int i = ev;  // kth building less 1 is the idx of that building in e,h
                int incrArea = last_x * e[i] * h[i];
                area = area + incrArea;
            }
        }

        return area;
    }
}
