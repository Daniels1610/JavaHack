package org.dagraz.LeetCode.Medium.M167;

import java.util.Arrays;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        final int n = numbers.length;
        int[] result = new int[2];


        int i = 0, j = 1;
        while (i < n) {
            if (j == i) {i++; j = (i + n + 1) % n;}

            if (numbers[i] + numbers[j] == target) {
                result[0] = ++i; result[1] = ++j; break;
            }
            j = (j + n + 1) % n;
        }

        return result;
    }

    public static void main(String[] args) {
        TwoSumII s = new TwoSumII();
        int[] numbers = {1,2,3,4,4,9,56,90}; int target = 8;
        System.out.println(Arrays.toString(s.twoSum(numbers, target)));
    }
}
