package org.dagraz.LeetCode.Easy.E392;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        final int ns = s.length(), nt = t.length();
        char[] sc = s.toCharArray(), tc = t.toCharArray();

        if (nt < ns) {return false;}

        int i = 0, j = 0;
        while (i < ns) {
            if (j >= nt) {break;}

            if (sc[i] == tc[j]) {
                i++; j++;
            }
            else {j++;}
        }
        return i == ns;
    }

    public static void main(String[] args) {
        IsSubsequence is = new IsSubsequence();
        String s = "acv", t = "ahbgdc";
        System.out.println(is.isSubsequence(s, t));
    }
}

