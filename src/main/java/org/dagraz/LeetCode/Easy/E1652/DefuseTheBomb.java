package org.dagraz.LeetCode.Easy.E1652;

/*
Status : Not Accepted (Fails some test cases)
Time Complexity: O(n * k)
Space Complexity: O(n)
*/

public class DefuseTheBomb {

    public int[] decrypt(int[] code, int k) {
        final int n = code.length;
        int[] decrypted_code = new int[n];

        int j = 1, p = 0;
        if (k != 0) {
            if (k < 0) {j = -1; k = Math.abs(k); p = n-1;}
            for (int i = 0; i < n; i ++) {
                decrypted_code[i] = circular_sum(code,i, k, j, p);
            }
        }
        return decrypted_code;
    }

    private int circular_sum(int[] code, int i, int k, int j, int p) {
        int dnum = 0; int n = code.length;
        for (int m = i; m < k + i; m++) {
            dnum += code[(m + j + p) % n];
        }
        return dnum;
    }

    public static void main(String[] args) {
        DefuseTheBomb s = new DefuseTheBomb();
        int[] code = {2,4,9,3}; int k = -2;
        int[] decrypted_code = s.decrypt(code , k);
        for (int x : decrypted_code) {System.out.printf("%d ", x);}

    }
}
