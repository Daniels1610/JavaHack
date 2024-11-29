package org.dagraz.LeetCode.Easy.E933;


import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCallsQueue {

    public static class RecentCounter {
        Queue<Integer> q;

        public RecentCounter() {
            this.q = new LinkedList<>();
        }

        public int ping(int t) {
            q.offer(t);
            while (q.peek() < t - 3000) {q.poll();}
            return q.size();
        }


        private void display() {
            System.out.print("[ ");
            for (int x : q) {
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
