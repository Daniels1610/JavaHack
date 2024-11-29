package org.dagraz.LeetCode.Easy.E1071;

public class GCDStringApproach2 {

    // GCD Algorithm Recursive
    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    // GCD Algorithm Iterative
//    private int gcd(int x, int y) {
//        int r = Integer.MAX_VALUE;
//        while (r != 0) {
//            r = x % y;
//            x = y; y = r;
//        }
//        return x;
//    }

    public String gcdOfStrings(String str1, String str2) {
        // Check if they have non-zero GCD string.
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Get the GCD of the two lengths.
        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

    public static void main(String[] args) {
        GCDStringApproach2 s = new GCDStringApproach2();
        String str1 = "TAUXXTAUXXTAUXXTAUXXTAUXX";
        String str2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
        System.out.println(s.gcdOfStrings(str1, str2));
    }
}
