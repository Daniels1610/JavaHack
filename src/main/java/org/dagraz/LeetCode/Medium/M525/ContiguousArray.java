package org.dagraz.LeetCode.Medium.M525;

import java.util.HashMap;
import java.util.Map;

/*
    Status: Accepted
    Time Complexity: O(n)
    Spatial Complexity: O(n)
    Program Runtime: 24ms | Beats 55.03%
    Memory Usage: 54.84MB | Beats 86.00%
 */

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        final int n = nums.length;
        int diff = 0; int maxLength = 0;
        Map<Integer, Integer> dmap = new HashMap<>(); // Difference Index Map
        dmap.put(0, -1);

        for (int i = 0; i < n; i++) {
            diff += (nums[i] == 1) ? 1 : -1;

            if (dmap.containsKey(diff)) {
                maxLength = Math.max(maxLength, i - dmap.get(diff));
            } else {
                dmap.put(diff, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        ContiguousArray s = new ContiguousArray();
        int[] nums = {0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        System.out.println(s.findMaxLength(nums));
    }
}
