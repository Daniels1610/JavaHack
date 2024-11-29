package org.dagraz.LeetCode.Easy.E1652;

/*
Status : Accepted
Time Complexity: O(n * k)
Space Complexity: O(n)
*/

public class DefuseTheBombClaude {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] decrypted = new int[n];

        if (k == 0) {
            return decrypted;
        }

        // Handle both positive and negative k
        if (k > 0) {
            for (int i = 0; i < n; i++) {
                decrypted[i] = sumNextKElements(code, i, k);
            }
        } else {
            for (int i = 0; i < n; i++) {
                decrypted[i] = sumPreviousKElements(code, i, -k);
            }
        }

        return decrypted;
    }

    private int sumNextKElements(int[] code, int start, int k) {
        int sum = 0;
        int n = code.length;
        for (int i = 1; i <= k; i++) {
            sum += code[(start + i) % n];
        }
        return sum;
    }

    private int sumPreviousKElements(int[] code, int start, int k) {
        int sum = 0;
        int n = code.length;
        for (int i = 1; i <= k; i++) {
            sum += code[(start - i + n) % n];
        }
        return sum;
    }

    public static void main(String[] args) {
        DefuseTheBombClaude s = new DefuseTheBombClaude();
        int[] code = {10,5,7,7,3,2,10,3,6,9,1,6}; int k = -4;
        int[] decrypted_code = s.decrypt(code , k);
        for (int x : decrypted_code) {System.out.printf("%d ", x);}
    }
}