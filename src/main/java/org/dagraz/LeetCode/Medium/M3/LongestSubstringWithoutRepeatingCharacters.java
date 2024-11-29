package org.dagraz.LeetCode.Medium.M3;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        final int n = s.length();
        Map<Character, Integer> cfmap = new HashMap<>(); // Char Fr
        int ln = 0;

        if (s.isEmpty()) {return 0;}


        String current = String.valueOf(s.charAt(0)), longest;
        longest = current;

        int i = 0, j = 1;
        while (j < n) {
            current = s.substring(i,j+1);
            if (i == j) {j++;}

            if (s.charAt(i) == s.charAt(j) ||
                current.contains(String.valueOf(s.charAt(j)))) {
                ln = Math.max(ln, longest.length());
                i++;
            }
            else j++;
            longest = current;


        }
        return ln;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters s = new LongestSubstringWithoutRepeatingCharacters();
        String s1 = "dvdf";
        System.out.println(s.lengthOfLongestSubstring(s1));
    }
}
