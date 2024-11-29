package org.dagraz.LeetCode.Easy.E268;

public class MissingNumberXOR {

    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        MissingNumberXOR s = new MissingNumberXOR();
        int[] nums = {3,5,1,2,0};
        System.out.println(s.missingNumber(nums));
    }

}
