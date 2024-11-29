package org.dagraz.LeetCode.Easy.E1732;

public class FindHighestAltitude {
    public int largestAltitude(int[] gain) {
        final int n = gain.length;
        int[] altitudes = new int[n + 1];

        // Prefix Sum: P[i] = A[0] + A[1] + ... + A[i]
        int prev = 0;
        for (int i = 1, j = 0; i < n + 1; i++, j++) {
            prev += gain[j];
            altitudes[i] = prev;
        }

        display(altitudes);

        return findMax(altitudes, altitudes.length);
    }

    private int findMax(int[] arr, int n) {
        int maxValue = arr[0];
        for (int i = 1; i < n; i++) {
            maxValue = Math.max(maxValue, arr[i]);
        }
        return maxValue;
    }

    private void display(int[] arr) {
        System.out.print("[ ");
        for (int x : arr) System.out.printf("%d ", x);
        System.out.print("]\n");
    }

    public static void main(String[] args) {
        FindHighestAltitude s = new FindHighestAltitude();
        int[] gain = {-5, 1, 5, 0, -7};
        System.out.println(s.largestAltitude(gain));
    }
}
