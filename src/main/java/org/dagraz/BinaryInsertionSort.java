package org.dagraz;

public class BinaryInsertionSort {
    int[] nums;
    final int N;

    public BinaryInsertionSort(int[] nums) {
        this.nums = nums;
        this.N = nums.length;
    }

    public void sort() {
        /* First Loop: 'i' pointer starts on 2nd element,
           as it takes the (i - 1)th slot like a sorted subarray */
        for (int i = 1; i < N; i++) {
            int x = nums[i];

            int idx = binary_search(i, x);
            nums[idx] = x;
        }
    }

    private int binary_search(int high, int target) {
        int low = 0;
        if (high <= 1) {return low;}

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }

    private void display() {
        System.out.print("[ ");
        for (int x : nums) System.out.printf("%d ", x);
        System.out.print("]");
    }

    public static void main(String[] args) {
        int[] nums = {8,7,3,5,2,1};
        BinaryInsertionSort s = new BinaryInsertionSort(nums);
        s.sort();
        s.display();
    }
}
