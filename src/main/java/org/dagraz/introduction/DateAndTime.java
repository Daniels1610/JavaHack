package org.dagraz.introduction;

import java.util.*;

class DateAndTime {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, day, 0, 0);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        String weekDay = "";

        switch (dayOfWeek) {
            case 1 -> {weekDay = "SUNDAY";}
            case 2 -> {weekDay = "MONDAY";}
            case 3 -> {weekDay = "TUESDAY";}
            case 4 -> {weekDay = "WEDNESDAY";}
            case 5 -> {weekDay = "THURSDAY";}
            case 6 -> {weekDay = "FRIDAY";}
            case 7 -> {weekDay = "SATURDAY";}
        }
        return weekDay;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int month = in.nextInt();
        int day = in.nextInt();
        int year = in.nextInt();
        System.out.println(findDay(month, day, year));
    }
}