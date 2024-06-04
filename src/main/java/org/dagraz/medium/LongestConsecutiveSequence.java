package org.dagraz.medium;

import java.util.Arrays;

// 128. Longest Consecutive Sequence
// https://leetcode.com/problems/longest-consecutive-sequence/description/

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int[] sorted = Arrays.stream(nums).sorted().toArray();
        int count = 0;

        for (int i = 0; i < nums.length; i++){
            if (i+1 == nums.length){count++; break;}
            if (Math.abs(sorted[i] - sorted[i+1]) == 1) {
                count++;
            }
        }
        System.out.printf("Longest Consecutive: %d", count);
    }
}