package org.dagraz.Hackerrank.easy;

public class SmallBills {
    public static int MakeChange(int amount) {
        int[] usd = {100, 50, 20, 10, 5, 2, 1};
        int idx = 0; int count = 0;

        while(idx != usd.length) {
            if (usd[idx] > amount) {idx++;}
            else {amount = amount % usd[idx]; count++;}
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.printf("Smallest Number of Bills: %d", MakeChange(53));
    }
}
