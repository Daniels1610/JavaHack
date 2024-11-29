package org.dagraz.LeetCode.Easy.E303;

public class RangeSumQueryNeetCode {
    int[] M;

    public RangeSumQueryNeetCode(int[] nums) {
        int n = nums.length;
        M = new int[n];
        M[0] = nums[0];
        for (int i = 1; i < n; i++) {
            M[i] = M[i - 1] + nums[i];
        }
        this.display(M);
    }

    public int sumRange(int left, int right) {
        if (left == 0) {return M[right];}
        return M[right] - M[left - 1];
    }

    private void display(int[] arr) {
        System.out.print("[ ");
        for (int x : arr) System.out.printf("%d ", x);
        System.out.print("]\n");
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQueryNeetCode obj = new RangeSumQueryNeetCode(nums);
        int left = 0, right = 5;
        System.out.println(obj.sumRange(left, right));
    }
}
