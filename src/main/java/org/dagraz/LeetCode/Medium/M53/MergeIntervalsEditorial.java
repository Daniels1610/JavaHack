package org.dagraz.LeetCode.Medium.M53;

// Editorial solution for Leetcode #56 Merge Intervals.
// Time Complexity O(nlogn)
// Space Complexity O(logN) (or O(n))

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervalsEditorial {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervalsEditorial s = new MergeIntervalsEditorial();

        int[][] i = {{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] i2 = {{1,3}, {4,6}, {8,10}, {15,18}};
        int[][] i3 = {{1,9}, {2,5}, {19,20}, {10,11}, {12,20}, {0,3}, {0,1}, {0,2}};

        int[][] r =  s.merge(i3);
        System.out.println(Arrays.deepToString(r));
    }
}
