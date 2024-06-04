package org.dagraz.introduction;

import java.util.*;

public class JavaEoF {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = 1;
        while (sc.hasNext()) {
            System.out.printf("%d %s\n", i, sc.nextLine());
            i++;
        }

        sc.close();
    }
}
