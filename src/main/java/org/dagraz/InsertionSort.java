package org.dagraz;

public class InsertionSort {
    int[] nums;
    final int N;

    public InsertionSort(int[] nums) {
        this.nums = nums;
        this.N = nums.length;
    }

    public void sort() {
        /* First Loop: 'i' pointer starts on 2nd element,
           as it takes the (i - 1)th slot like a sorted subarray */
        for (int i = 1; i < N; i++) {
            int x = nums[i];
            int j = i - 1;

            /* Second loop:
            Enters the while loop if the ith element has to be
            rearranged in the sorted subarray.
            */
            while (j >= 0 && nums[j] > x) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = x;
        }
    }

    private void display() {
        System.out.print("[ ");
        for (int x : nums) System.out.printf("%d ", x);
        System.out.print("]");
    }

    public static void main(String[] args) {
        int[] nums = {8,7,3,5,2,1};
        InsertionSort s = new InsertionSort(nums);
        s.sort();
        s.display();

    }
}
