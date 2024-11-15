package org.dagraz;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class BinarySearch {

    public int binary_search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = IntStream.generate(() ->
                new Random().nextInt(1000) + 1000).limit(100).toArray();

        int[] arr_sorted = Arrays.stream(arr).sorted().toArray();

        int[] a = {1,4,6,9,12,16,21,33};

        BinarySearch s = new BinarySearch();
        System.out.println(s.binary_search(a, 21));
    }
}
