package org.dagraz.LeetCode.Easy.E1768;

public class MergeStringA2Pointers {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        StringBuilder merged = new StringBuilder();

        int i = 0, j = 0;
        while (i < n || j < m) {
            if (i < n) {
                merged.append(word1.charAt(i++));
            } if (j < m) {
                merged.append(word2.charAt(j++));
            }
        }

        return merged.toString();
    }

    public static void main(String[] args) {
        MergeStringA2Pointers s = new MergeStringA2Pointers();
        String w1 = "ab", w2 = "pqrs";
        System.out.println(s.mergeAlternately(w1, w2));
    }
}
