package org.dagraz.LeetCode.Easy.E933;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class NumberOfRecentCalls {

    public static class RecentCounter {
        List<Integer> requests;
        int ping;

        public RecentCounter() {
            this.requests = new ArrayList<>();
            this.ping = 0;
        }

        public int ping(int t) {
            requests.add(t); ping = 0;
            int lower_bound = t - 3000;

            for (Integer request : requests) {
                if (request >= lower_bound && request <= t) ping++;
            }
            return ping;
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
        obj.ping(t1);
        obj.ping(t2);
        obj.ping(t3);
        int param_4 = obj.ping(t4);
        obj.display();
        System.out.println(param_4);

    }


}
