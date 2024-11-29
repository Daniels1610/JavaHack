package org.dagraz.LeetCode.Medium.M167;

import java.util.Arrays;

public class TwoSumIIBinarySearch {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else if (numbers[mid] < target - numbers[i]) {
                    low = mid + 1;
                } else {
                    return new int[]{i + 1, mid + 1};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSumIIBinarySearch s = new TwoSumIIBinarySearch();
        int[] numbers = {1,2,3,4,4,9,56,90}; int target = 8;
//        int[] numbers = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
//        0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,3,9,9,
//        9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
//        9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
//        9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9};
//        int target = 5;
        System.out.println(Arrays.toString(s.twoSum(numbers, target)));
    }
}
