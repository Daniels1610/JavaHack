package org.dagraz.LeetCode.Medium.M53;

/* Naive Implementation of Merged Intervals Problem. No AC */

import java.util.Arrays;


public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {return intervals;}

        int[][] r = new int[intervals.length][2];
        int n = intervals.length;
        int j = 1;

        for (int i = 0; i < n - 1; i++) {
            int[] x = intervals[i], y = intervals[j];
            if (isOverlapping(x, y)){
                r[i] = new int[]{x[0], y[1]};
            }
            else {
                r[i] = new int[]{y[0], y[1]};
            }
            j++;
        }

        return r;
    }

    private boolean isOverlapping(int[] a, int[] b) {
        // BASE: Overlaps x's end_i with y's start_i
        return a[0] <= b[1] && b[0] <= a[1];

    }

    public static void main(String[] args) {
        MergeIntervals s = new MergeIntervals();

        int[][] i = {{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] i2 = {{1,3}, {4,6}, {8,10}, {15,18}};

        int[][] r =  s.merge(i2);
        System.out.println(Arrays.deepToString(r));
    }
}
