package org.dagraz.Hackerrank.introduction;

import java.util.*;

public class IntToString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer n = Integer.valueOf(in.nextInt());
        in.close();
        String s =  n.toString();

        if (n == Integer.parseInt(s)) {
            System.out.println("Good job");
        } else {
            System.out.println("Wrong answer.");
        }

    }
}


