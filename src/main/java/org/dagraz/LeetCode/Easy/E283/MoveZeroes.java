package org.dagraz.LeetCode.Easy.E283;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        final int n = nums.length;
        int j = findFirstZero(nums, n);

        if (j == -1) {return;}

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0 && j < i) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j = findFirstZero(nums, n);
            }
        }
    }

    private int findFirstZero(int[] nums, int n) {
        int a = -1;
        for (int k = 0; k < n; k++) {
            if (nums[k] == 0) {a = k; break;}
        }
        return a;
    }

    public static void main(String[] args) {
        MoveZeroes s = new MoveZeroes();
        int[] nums = {0,1,0,3,12};
        s.moveZeroes(nums);

        for (int i : nums) {System.out.printf("%d ", i);}
    }
}
