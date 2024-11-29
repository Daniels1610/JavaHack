package org.dagraz.LeetCode.Easy.E303;

public class RangeSumQuery {
    int[] nums;
    int[] P;
    int n;

    public RangeSumQuery(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.P = new int[n];
        prefixSum();
        this.display(this.P);
    }

    public int sumRange(int left, int right) {
        if (left == 0) {return this.P[right];}
        return this.P[right] - this.P[left - 1];
    }

    private void prefixSum() {
        int prev = 0;
        for (int i = 0; i < this.n; i++) {
            prev += this.nums[i];
            this.P[i] = prev;
        }
    }

    private void display(int[] arr) {
        System.out.print("[ ");
        for (int x : arr) System.out.printf("%d ", x);
        System.out.print("]\n");
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQuery obj = new RangeSumQuery(nums);
        int left = 0, right = 5;
        System.out.println(obj.sumRange(left, right));
    }
}
