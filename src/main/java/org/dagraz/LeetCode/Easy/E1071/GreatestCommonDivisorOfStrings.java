package org.dagraz.LeetCode.Easy.E1071;

public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        int s1 = str1.length(), s2 = str2.length();
        String result = ""; String temp;
        StringBuilder sb = new StringBuilder();

        if (Math.max(s1, s2) == s1) {sb.append(str2);}
        else {sb.append(str1); s1 = s2; str1 = str2;}

        int c = 0;
        int i = sb.length(), j = sb.length() - 1;
        while (i > 0) {
            str2 = sb.toString();
            temp = str2.repeat(s1 / i);

            if (temp.equals(str1)) {
                if (str2.length() != (s1 / i)+1){
                    result = sb.substring(0, i - c); break;
                }
                result = str2; break;
            }

            sb.deleteCharAt(j--); i--; c++;
        }

        return result;
    }

    public static void main(String[] args) {
        GreatestCommonDivisorOfStrings s = new GreatestCommonDivisorOfStrings();
        String str1 = "TAUXXTAUXXTAUXXTAUXXTAUXX"; String str2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
        System.out.println(s.gcdOfStrings(str1, str2));
    }
}
