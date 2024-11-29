package org.dagraz.LeetCode.Medium.M167;

import java.util.Arrays;

public class TwoSumIITwoPointers {
    public int[] twoSum(int[] numbers, int target) {
        final int n = numbers.length;

        int i = 0, j = n - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{++i, ++j};
            }

            if (numbers[i] + numbers[j] > target) j--;
            else {i++;}
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSumIITwoPointers s = new TwoSumIITwoPointers();
        int[] numbers = {1,2,3,4,4,9,56,90}; int target = 8;
        System.out.println(Arrays.toString(s.twoSum(numbers, target)));
    }
}
