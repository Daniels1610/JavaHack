package org.dagraz.Hackerrank.hard;

import org.javatuples.Pair;
import java.util.Arrays;
import java.util.Scanner;

public class MinimumArea {

    public static int minArea(int[] x, int[] y, int k) {
        int[] arr_maxX = Arrays.copyOf(x, x.length);
        int[] arr_maxY = Arrays.copyOf(y, y.length);
        int minX, maxX;
        int minY, maxY;
        for (int i = 0; i < x.length; i++){
            x[i]--; y[i]--;
        }
        Arrays.sort(x); Arrays.sort(y);
        minX = x[0]; minY = y[0];
        for (int j = 0; j < x.length; j++){
            arr_maxX[j]++; arr_maxY[j]++;
        }
        Arrays.sort(arr_maxX); Arrays.sort(arr_maxY);
        maxX = arr_maxX[arr_maxX.length-1]; maxY = arr_maxY[arr_maxY.length-1];
        return (int) Math.pow(euclidean(new Pair<>(minX, minY), new Pair<>(maxY, minX)), 2);
    }

    public static int euclidean(Pair<Integer, Integer> x, Pair<Integer, Integer> y){
        double xs = Math.pow(x.getValue1().doubleValue() - x.getValue0().doubleValue(), 2);
        double ys = Math.pow(y.getValue1().doubleValue() - y.getValue0().doubleValue(), 2);
        return (int) Math.sqrt(xs + ys);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nx = sc.nextInt();
        int[] x = new int[nx];
        for (int i = 0; i < nx; i++){
            int s = sc.nextInt();
            x[i] = s;
        }
        int ny = sc.nextInt();
        int[] y = new int[ny];
        for (int j = 0; j < ny; j++){
            int r = sc.nextInt();
            y[j] = r;
        }
        int k = sc.nextInt();
        sc.close();

        System.out.printf("nx: %d | ny: %d\n", nx, ny);
        System.out.printf("x: %s | y: %s\n", Arrays.toString(x), Arrays.toString(y));
        System.out.printf("k: %d\n", k);

        long start = System.nanoTime();
        System.out.printf("Minimum Area: %d\n", minArea(x,y,k));
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.printf("Execution Time:  %f seconds", (double) timeElapsed / (long) Math.pow(10, 9));
    }
}
