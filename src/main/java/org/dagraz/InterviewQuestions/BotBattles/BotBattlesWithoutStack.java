package org.dagraz.InterviewQuestions.BotBattles;

/* Bot Battles Problem
 Write a program to return the number of remaining robots after a game is over
 Blue Robots are represented by the number 1 (Shift to Right)
 Red Robots are represented by the number 2 (Shift to Left) */

public class BotBattlesWithoutStack {

    int get_remaining_robots(int[][] game) {
        int remaining = 0;

        for (int[] battle : game) {
            int rem = 0, last_robot = 0;
            for (int i : battle) {
                if (i != 0) {
                    if (i == 2 && last_robot == 1) {
                        rem--;
                        if (rem == 0) {last_robot = 0;}
                    } else if (i == 1 && last_robot == 2) {
                        rem++;
                        last_robot = i;
                    }
                    else {
                        rem++;
                        last_robot = i;
                    }
                }
            }
            System.out.println(rem);
            remaining += rem;
        }
        return remaining;
    }

    public static void main(String[] args) {
        BotBattlesWithoutStack s = new BotBattlesWithoutStack();
        int[][] game =
           {{1,0,0,0,0,0,0,2,1,1},      // 2
            {0,0,1,1,0,2,0,0,2,1},      // 1
            {0,2,0,0,1,0,2,0,1,0},      // 2
            {0,2,2,2,0,0,0,1,0,0},      // 4
            {0,1,2,1,2,2,0,2,0,0},      // 2
            {1,0,1,0,0,1,0,2,1,0}};     // 3

        System.out.println(s.get_remaining_robots(game));
    }
}
