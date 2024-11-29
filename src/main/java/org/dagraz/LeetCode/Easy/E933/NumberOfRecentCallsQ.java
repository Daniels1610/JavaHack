package org.dagraz.LeetCode.Easy.E933;

import java.util.ArrayList;
import java.util.List;


public class NumberOfRecentCallsQ {

    public static class RecentCounter {
        int[] requests;
        int start;
        int end;

        public RecentCounter() {
            this.requests = new int[10000];
            this.start = 0;
            this.end= 0;
        }

        public int ping(int t) {
            while (start < end && (t - requests[start] > 3000)) {
                start++;
            }
            requests[end++] = t;
            return end - start;
        }


        private void display() {
            System.out.print("[ ");
            for (int x : requests) {
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
