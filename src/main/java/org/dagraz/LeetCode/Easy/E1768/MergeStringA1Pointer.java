package org.dagraz.LeetCode.Easy.E1768;

public class MergeStringA1Pointer {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        StringBuilder merged = new StringBuilder();

        int i = 0;
        while (i < Math.max(n, m)) {
            if (i < n) {
                merged.append(word1.charAt(i));
            } if (i < m) {
                merged.append(word2.charAt(i));
            }
            i++;
        }

        return merged.toString();
    }

    public static void main(String[] args) {
        MergeStringA1Pointer s = new MergeStringA1Pointer();
        String w1 = "ab", w2 = "pqrs";
        System.out.println(s.mergeAlternately(w1, w2));
    }
}
