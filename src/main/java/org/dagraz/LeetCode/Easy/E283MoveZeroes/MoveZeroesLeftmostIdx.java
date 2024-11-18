package org.dagraz.LeetCode.Easy.E283MoveZeroes;

public class MoveZeroesLeftmostIdx {
    public void moveZeroes(int[] nums) {
        int leftMostZeroIndex = 0; // The index of the leftmost zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > leftMostZeroIndex) { // There are zero(s) on the left side of the current non-zero number, swap!
                    nums[leftMostZeroIndex] = nums[i];
                    nums[i] = 0;
                }

                leftMostZeroIndex++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroesLeftmostIdx s = new MoveZeroesLeftmostIdx();
        int[] nums = {0,1,0,3,12};
        s.moveZeroes(nums);

        for (int i : nums) {System.out.printf("%d ", i);}
    }
}


