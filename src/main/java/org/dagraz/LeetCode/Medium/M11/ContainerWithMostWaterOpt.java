package org.dagraz.LeetCode.Medium.M11;

public class ContainerWithMostWaterOpt {

    public int maxArea(int[] height) {
        final int n = height.length;
        int maxArea = 0;
        int l = 0, r = n - 1;

        while (l < r) {
            maxArea = Math.max(maxArea, getArea(height, l, r));
            if (height[l] <= height[r]){l++;}
            else if (height[r] < height[l]){r--;}
        }

        return maxArea;
    }

    private int getArea(int[] height, int left, int right) {
        int w = right - left;
        int h = Math.min(height[left], height[right]);
        return w * h;
    }

    public static void main(String[] args) {
        ContainerWithMostWaterOpt s = new ContainerWithMostWaterOpt();
        int[] height = {8,7,2,1};
        System.out.println(s.maxArea(height));
    }
}
