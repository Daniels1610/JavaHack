package org.dagraz.LeetCode.Easy.E268;

/*
Status: AC
Time Complexity: O(nlogn)
Space Complexity: O(1)
Runtime: 6ms | Beats 12.20%
Memory Usage: 45.46MB | Beats 22.93%
*/

import java.util.Arrays;

public class MissingNumber {

    public int getMissingNumber(int[] nums) {
        final int n = nums.length;
        Arrays.sort(nums);
        int result = 0;

        if (n == 1 && nums[0] == 1) {return result;}
        else if (n == 1 && nums[0] == 0) {return ++result;}

        int j = 1;
        for (int i = 0; i < n - 1; i++) {
            int delta = nums[j] - nums[i];
            if (delta != 1) {return nums[j] - 1;}
            j++;
        }

        if (result == 0 && nums[0] == 0) {result = nums[n-1] + 1;}
        else {result = 0;}

        return result;

    }

    public static void main(String[] args) {
        MissingNumber s = new MissingNumber();
        int[] n = {1,2};
        System.out.println(s.getMissingNumber(n));
    }
}
