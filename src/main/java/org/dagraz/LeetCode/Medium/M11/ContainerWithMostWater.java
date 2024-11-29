package org.dagraz.LeetCode.Medium.M11;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        final int n = height.length;
        int rvalue = getAvg(height, n);

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            if (height[i] >= rvalue) {
                int j = n - 1;
                while(i <= j) {
                    if (height[i] >= height[j]) {
                        maxArea = Math.max(maxArea, (j- i) * height[j]);
                    } else {
                        maxArea = Math.max(maxArea, (j- i) * height[i]);
                    }
                    j--;
                }
            }
        }
        return maxArea;
    }

    private int getAvg(int[] height, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += height[i];
        }
        return sum / n;
    }

    public static void main(String[] args) {
        ContainerWithMostWater s = new ContainerWithMostWater();
        int[] height = {1,8,2,3,4,5,6,7,8};
        System.out.println(s.maxArea(height));
    }
}
