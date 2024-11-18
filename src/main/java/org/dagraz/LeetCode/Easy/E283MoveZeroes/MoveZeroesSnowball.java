package org.dagraz.LeetCode.Easy.E283MoveZeroes;

public class MoveZeroesSnowball {

    public void moveZeroes(int[] nums) {
        final int n = nums.length;
        int snowballSize = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                snowballSize++;
            }
            else if (snowballSize > 0) {
                int temp = nums[i];
                nums[i] = 0;
                nums[i-snowballSize] = temp;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroesSnowball s = new MoveZeroesSnowball();
        int[] nums = {0,1,0,3,12};
        s.moveZeroes(nums);

        for (int i : nums) {System.out.printf("%d ", i);}
    }
}
