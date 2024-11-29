package org.dagraz.LeetCode.Easy.E1652;


public class DefuseTheBombWindowTech {
    public int[] decrypt(int[] code, int k) {
        final int N = code.length;
        int[] result = new int[N];

        if (k == 0) {
            return result;
        }

        int l = 0;
        int cur_sum = 0;

        for (int r = 0; r < N + Math.abs(k); r++){
            cur_sum += code[r % N];

            if (r - l + 1 > Math.abs(k)) {
                cur_sum -= code[l % N];
                l = (l + 1) % N;
            }

            if (r - l + 1 == Math.abs(k)) {
                if (k > 0) {
                    result[(l - 1 + N) % N] = cur_sum;
                } else if (k < 0) {
                    result[(r + 1) % N] = cur_sum;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        DefuseTheBombWindowTech s = new DefuseTheBombWindowTech();
        int[] code = {2,4,9,3}; int k = -2;
        int[] decrypted_code = s.decrypt(code , k);
        for (int x : decrypted_code) {System.out.printf("%d ", x);}
    }
}
