package org.dagraz.LeetCode.Easy.E643MaximumAverageSubarrayI;


import java.util.Arrays;

class MaximumAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        double max_avg = Double.MIN_NORMAL;
        final int n = nums.length;

        if (n == k) {return getAvg(nums, n);}

        for (int i = 0; i < n; i++) {
            if (i+k > n) {break;}
            int[] newArray = Arrays.copyOfRange(nums, i, i+k);
            max_avg = Math.max(getAvg(newArray, newArray.length), max_avg);
        }
        return max_avg;
    }

    private double getAvg(int[] arr, int n) {
        double r = 0.0;
        for (int i = 0; i < n; i++) {
            r += arr[i];
        }
        return r / n;
    }


    public static void main(String[] args) {
        MaximumAverageSubarray s = new MaximumAverageSubarray();
        int[] nums = {6,8,6,8,0,4,1,2,9,9};
        int k = 2;
        System.out.println(nums.length);
        System.out.println(s.findMaxAverage(nums, k));
    }
}