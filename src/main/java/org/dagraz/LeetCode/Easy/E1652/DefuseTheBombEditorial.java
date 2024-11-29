package org.dagraz.LeetCode.Easy.E1652;


class DefuseTheBombEditorial {

    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];
        if (k == 0) return result;
        // Define the initial window and initial sum
        int start = 1, end = k, sum = 0;
        // If k < 0, the starting point will be end of the array.
        if (k < 0) {
            start = code.length - Math.abs(k);
            end = code.length - 1;
        }
        for (int i = start; i <= end; i++) sum += code[i];
        // Scan through the code array as i moving to the right, update the window sum.
        for (int i = 0; i < code.length; i++) {
            result[i] = sum;
            sum -= code[(start) % code.length];
            sum += code[(end + 1) % code.length];
            start++;
            end++;
        }
        return result;
    }

    public static void main(String[] args) {
        DefuseTheBombEditorial s = new DefuseTheBombEditorial();
        int[] code = {10,5,7,7,3,2,10,3,6,9,1,6}; int k = -4;
        int[] decrypted_code = s.decrypt(code , k);
        for (int x : decrypted_code) {System.out.printf("%d ", x);}
    }
}