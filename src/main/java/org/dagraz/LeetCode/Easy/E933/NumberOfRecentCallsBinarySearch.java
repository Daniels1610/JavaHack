package org.dagraz.LeetCode.Easy.E933;


import java.util.*;

public class NumberOfRecentCallsBinarySearch {

    public static class RecentCounter {
        List<Integer> list;

        public RecentCounter() {
            this.list = new ArrayList<>();
        }

        public int ping(int t) {
            list.add(t);
//            int index = Collections.binarySearch(list, t - 3000); // This line works.
            int index = binary_search(t - 3000); // search the index of t - 3000.
            if (index < 0) { index = ~index; } // if t - 3000 is not in list, use the index of the ceiling of t - 3000.
            return list.size() - index;
        }

        private int binary_search(int target) {
            int low = 0; int high = list.size();

            while(low < high) {
                int mid = (low + high) / 2;

                if (target > list.get(mid)) {
                    low = mid + 1;
                } else if (target < list.get(mid)) {
                    high = mid;
                } else {
                    return mid;
                }
            }
            return -1;
        }

        private void display() {
            System.out.print("[ ");
            for (int x : list) {
                System.out.printf("%d ", x);
            }
            System.out.print("]"); System.out.println();
        }

    }

    public static void main(String[] args) {
        RecentCounter obj = new RecentCounter();
        int t1 = 1, t2 = 100, t3 = 3001, t4 = 3002;
        int param_1 = obj.ping(t1);
        int param_2 = obj.ping(t2);
        int param_3 = obj.ping(t3);
        int param_4 = obj.ping(t4);
        obj.display();
        System.out.printf("[ %d %d %d %d ]", param_1, param_2, param_3, param_4);

    }


}
