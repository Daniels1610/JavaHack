package org.dagraz.LeetCode.Easy.E268;

public class MissingNumberSum {
    public int missingNumber(int[] nums) {
        final int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    public static void main(String[] args) {
        MissingNumberSum s = new MissingNumberSum();
        int[] nums = {0,3,8,4,1,9,5,7,2};
        System.out.println(s.missingNumber(nums));
    }
}
