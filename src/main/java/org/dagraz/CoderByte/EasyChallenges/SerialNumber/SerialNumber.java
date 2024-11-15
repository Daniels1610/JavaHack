package org.dagraz.CoderByte.EasyChallenges.SerialNumber;

/*
Have the function SerialNumber(str) take the str parameter being passed
and determine if it is a valid serial number with the following constraints:

1. It needs to contain three sets each
   with three digits (1 through 9) se-
   parated by a period.

2. The first set of digits must add up
   to an even number.

3. The second set of digits must add up
   to an odd number.

4. The last digit in each set must be
   larger than the two previous digits
   in the same set.
*/

public class SerialNumber {

    public boolean serial_number(String strParam) {
        int checks = 0;
        int fchecks = 0;

        // 1st Constraint
        if (!strParam.matches("\\d{3}\\.\\d{3}\\.\\d{3}")) {return false;}

        String[] sets = strParam.split("\\.");
        int first = sum(get_num(sets[0]));
        int second = sum(get_num(sets[1]));

        // 2nd & 3rd Constraint
        if (first % 2 != 0 || second % 2 == 0) {return false;}

        // 4th Constraint
        for (int i = 0; i < sets.length; i++) {
            int[] a = get_num(sets[i]);
            if (a[2] <= a[0] || a[2] <= a[1]) {return false;}
        }

        return true;
    }

    private int sum(int[] arr) {
        int x = 0;
        for (int i : arr) {
            x += i;
        }
        return x;
    }

    private int[] get_num(String strParam) {
        char[] x = strParam.toCharArray();
        int[] a = {0,0,0};
        for (int i = 0; i < strParam.length(); i++) {
             a[i] = Integer.parseInt(String.valueOf(x[i]));
        }
        return a;
    }

    public static void main(String[] args) {
        SerialNumber s = new SerialNumber();
        runTestCases(s);
    }

    private static void runTestCases(SerialNumber validator) {
        // Test Case Format: {serial number, expected result, description}
        Object[][] testCases = {
                // Valid serial numbers
                {"114.568.112", true, "Valid serial - basic case"},
                {"123.458.123", true, "Valid serial - minimum requirements"},

                // Invalid format
                {"11.568.112", false, "Invalid - wrong format"},
                {"114.56.112", false, "Invalid - missing digits"},
                {"114-568-112", false, "Invalid - wrong separator"},
                {"114.568.1122", false, "Invalid - too many digits"},

                // Invalid first set (must be even sum)
                {"115.568.112", false, "Invalid - first set odd sum"},
                {"124.568.112", false, "Invalid - first set odd sum"},
                {"234.678.123", false, "Valid serial - first set odd sum"},

                // Invalid second set (must be odd sum)
                {"114.567.112", false, "Invalid - second set even sum"},
                {"114.666.112", false, "Invalid - second set even sum"},

                // Invalid last digit not largest
                {"111.568.112", false, "Invalid - first set last digit not largest"},
                {"114.566.112", false, "Invalid - second set last digit not largest"},
                {"114.568.111", false, "Invalid - third set last digit not largest"},

                // Edge cases
                {"999.999.999", false, "Invalid - all nines"},
                {"248.357.469", true, "Valid - increasing digits"},
                {"800.901.902", false, "Invalid - zeros included"}
        };

        int passed = 0;
        int total = testCases.length;

        for (Object[] test : testCases) {
            String serial = (String) test[0];
            boolean expected = (boolean) test[1];
            String description = (String) test[2];

            boolean result = validator.serial_number(serial);
            boolean testPassed = result == expected;

            if (testPassed) {
                passed++;
            }

            System.out.printf("Test: %s - %s%n",
                    description,
                    testPassed ? "PASSED" : "FAILED");
            System.out.printf("Input: %s, Expected: %b, Got: %b%n%n",
                    serial,
                    expected,
                    result);
        }

        System.out.printf("Total Tests: %d%nPassed: %d%nFailed: %d%n",
                total,
                passed,
                total - passed);
    }
}
