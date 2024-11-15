package org.dagraz.InterviewQuestions.BotBattles;

import java.util.Stack;

/* Bot Battles Problem
 Write a program to return the number of remaining robots after a game is over
 Blue Robots are represented by the number 1 (Shift to Right)
 Red Robots are represented by the number 2 (Shift to Left) */

public class BotBattlesStack {

    public int get_remaining_robots(int[][] game) {
        Stack<Integer> stack = new Stack<>();
        int remaining = 0;

        for (int[] battle : game) {
            for (int i : battle) {
                if (i != 0) {
                    if (!stack.empty() && i == 2 && stack.peek() == 1) {
                        stack.pop();
                    }
                    else {
                        stack.push(i);
                    }
                }
            }
            remaining += stack.size();
            stack.clear();
        }
        return remaining;
    }

    public static void main(String[] args) {
        BotBattlesStack s = new BotBattlesStack();
        int[][] game =
           {{1,0,0,0,0,0,0,2,1,1},      // 2
            {0,0,1,1,0,2,0,0,2,1},      // 1
            {0,2,0,0,1,0,2,0,1,0},      // 2
            {0,2,2,2,0,1,0,0,0,0},      // 4
            {0,1,2,1,2,2,0,2,0,0},      // 2
            {1,0,1,0,0,1,0,2,1,0}};     // 3

        System.out.println(s.get_remaining_robots(game));
    }
}
