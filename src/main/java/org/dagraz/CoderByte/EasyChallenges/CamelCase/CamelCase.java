package org.dagraz.CoderByte.EasyChallenges.CamelCase;

import java.util.Arrays;
import java.util.regex.Pattern;

public class CamelCase {

    public String camel_case(String strParam) {
        String[] parsed = strParam.split("\\p{Punct}");

        String camel_string = "";
        for (int i = 0; i < parsed.length; i++) {
            if (i == 0) {parsed[i] = parsed[i].toLowerCase();}
            else {parsed[i] = capitalize(parsed[i]);}
            camel_string = camel_string.concat(parsed[i]);
        }

        return camel_string;
    }

    private String capitalize(String strParam) {
        return strParam.substring(0, 1).toUpperCase() + strParam.substring(1).toLowerCase();
    }

    public static void main(String[] args) {
        CamelCase s = new CamelCase();
        String s1 = "Catch*me.iF@yOU-cAn";
        System.out.println(s.camel_case(s1));
    }
}


