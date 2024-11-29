package org.dagraz.LeetCode.Easy.E268;

/*
Status: AC
Time Complexity: O(nlogn)
Space Complexity: O(1)
Runtime: 5ms | Beats 25.27 %
Memory Usage: 45.28MB | Beats 45.84%
*/

import java.util.Arrays;

public class MissingNumberOnePointer {
    public int getMissingNumber(int[] nums) {
        final int n = nums.length;
        int result = 0;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return result + n;
    }

    public static void main(String[] args) {
        MissingNumberOnePointer s = new MissingNumberOnePointer();
        int[] nums = {1,2};
        System.out.println(s.getMissingNumber(nums));
    }
}
