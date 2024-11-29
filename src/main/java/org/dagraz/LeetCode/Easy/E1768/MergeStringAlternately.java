package org.dagraz.LeetCode.Easy.E1768;


public class MergeStringAlternately {

    public String mergeAlternately(String word1, String word2) {
        char[] wc1 = word1.toCharArray(), wc2 = word2.toCharArray();
        int wn1 = word1.length(), wn2 = word2.length();
        char[] merged = new char[wn1 + wn2];

        int turn = 0;

        for (int i = 0, j = 0, k = 0; i < wn1 + wn2; i++) {
            if (turn % 2 == 0 && j < wn1) {
                merged[i] = wc1[j]; j++;
            } else if (turn % 2 != 0 &&  k < wn2) {
                merged[i] = wc2[k]; k++;
            } else {
                if (Math.max(wn1, wn2) == wn1) {merged[i] = wc1[j]; j++;}
                else {merged[i] = wc2[k]; k++;}
            }
            turn++;
        }
        return String.valueOf(merged);
    }

    public static void main(String[] args) {
        MergeStringAlternately s = new MergeStringAlternately();
        String w1 = "ab", w2 = "pqrs";
        System.out.println(s.mergeAlternately(w1, w2));
    }
}
