package org.dagraz.Hackerrank.introduction;

import java.util.*;

public class StaticInitializerBlock {

    public static Result result = initializeInput();

    public static void checkInput() throws Exception {
        if (result.getHeight() <= 0 || result.getBase() <= 0){
            throw new Exception("Breadth and height must be positive");
        }
    }

    private static Result initializeInput() {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        return new Result(h, b);
    }

    public static int getArea(int b, int h){
        return b * h;
    }

    public static void main(String[] args) {
        try {
            checkInput();
            System.out.println(getArea(result.getBase(), result.getHeight()));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

final class Result {
    private final int h;
    private final int b;

    public Result(int h, int b) {
        this.h = h;
        this.b = b;
    }

    public int getBase() {return b;}

    public int getHeight() {return h;}
}