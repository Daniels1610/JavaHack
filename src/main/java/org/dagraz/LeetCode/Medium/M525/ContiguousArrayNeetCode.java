package org.dagraz.LeetCode.Medium.M525;

import java.util.HashMap;
import java.util.Map;

/*
    Status: Accepted
    Time Complexity: O(n)
    Spatial Complexity: O(n)
    Program Runtime: 24ms | Beats 55.03%
    Memory Usage: 55.20MB | Beats 41.39%
 */

public class ContiguousArrayNeetCode {
    public int findMaxLength(int[] nums) {
        final int n = nums.length;
        int one = 0, zero = 0; int maxLength = 0;
        Map<Integer, Integer> dmap = new HashMap<>(); // Difference Index Map

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {one++;}
            else {zero++;}

            int diff = one - zero;
            if (!dmap.containsKey(diff)) {
                dmap.put(diff, i);
            }

            if (diff == 0) {
                maxLength = one + zero;
            } else {
                int idx = dmap.get(diff);
                maxLength = Math.max(maxLength, i - idx);
            }
        }
        return maxLength;
    }

    private void display(int[] arr) {
        System.out.print("[ ");
        for (int x : arr) System.out.printf("%d ", x);
        System.out.print("]\n");
    }

    public static void main(String[] args) {
        ContiguousArrayNeetCode s = new ContiguousArrayNeetCode();
        int[] nums = {0, 1};
        System.out.println(s.findMaxLength(nums));
    }
}
