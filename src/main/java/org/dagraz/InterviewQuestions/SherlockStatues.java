package org.dagraz.InterviewQuestions;

/* Sherlock's Birthday Statues
Sherlock got statues of different (they can repeat) sizes as a gift
from his best friend Watson. Each statue has a particular non-negative
integer height. But Sherlock being a man of perfection, he wants all the
statues from smallest to largest so that each statue will be taller than
the previous one exactly by 1. He may need additional statues to be able
to accomplish the task. Please help Sherlock to find out the minimum number
of extra statues needed. */

import java.util.Arrays;

public class SherlockStatues {

    public int get_extra_statues (int[] arr, int n) {
        Arrays.sort(arr);
        int counter = 0;

        counter += arr[0] - 1;
        for (int i = 0; i < n-1; i++) {
            int delta = Math.abs(arr[i] - arr[i+1]);
            if (delta != 1) {
                counter += delta - 1;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        SherlockStatues s = new SherlockStatues();
        int[] s1 = {16, 7, 10, 3, 21, 15, 2};
        System.out.println(s.get_extra_statues(s1, s1.length));
    }
}
