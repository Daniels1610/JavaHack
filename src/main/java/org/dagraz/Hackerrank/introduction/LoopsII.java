package org.dagraz.Hackerrank.introduction;

import java.util.*;

// JAVA LOOPS II
// We use the integers 'a', 'b' and 'n' to create the following series:
// (a + 2^0 * b), (a + 2^0 * b + 2^1 * b), ..., (a + 2^0 * b + 2^1 * b + ... + 2^n * b)

// You are given 'q' queries in the form of a, b, and n. For each query, print the
// series corresponding to the given a, b and n values as a single line of
// n space-separated integers.

// Input Format
// The first line contains an integer 'q', denoting the number of queries.
// Each line 'i' of the 'q' subsequent lines contains three space-separated
// integers describing the respective ai, bi, and ni values for that query.

class LoopsII{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int a; int b; int n;
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            a = in.nextInt();
            b = in.nextInt();
            n = in.nextInt();
            int s_curr; int s_prev = a;
            for (int j = 0; j < n; j++){
                // Calculates current state
                s_curr = s_prev + (int)(Math.pow(2.0, j) * b);

                // Gets prepared for next iteration
                s_prev = s_curr;

                System.out.printf("%d ", s_prev);
            }
            System.out.print("\n");
        }
        in.close();
    }
}