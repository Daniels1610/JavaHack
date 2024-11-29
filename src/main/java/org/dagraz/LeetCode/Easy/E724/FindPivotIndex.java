package org.dagraz.LeetCode.Easy.E724;

import java.util.Arrays;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        final int n = nums.length;
        int[] P = new int[n];
        int pidx = -1;

        P[0] = nums[0];
        for (int i = 1; i < n; i++) P[i] = P[i-1] + nums[i];
        System.out.println(Arrays.toString(P));

        int leftSum = 0; int rightSum;
        for (int i = 0; i < n; i++) {
            if (i != 0) leftSum = P[i-1];
            rightSum = P[n-1] - P[i];

            if (leftSum - rightSum == 0) return i;
        }

        return pidx;
    }

    public static void main(String[] args) {
        FindPivotIndex s = new FindPivotIndex();
        int[] nums = {-1,-1,0,0,-1,-1};
        System.out.println(s.pivotIndex(nums));
    }

}
