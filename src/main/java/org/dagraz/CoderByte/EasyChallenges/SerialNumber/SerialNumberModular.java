package org.dagraz.CoderByte.EasyChallenges.SerialNumber;


public class SerialNumberModular {
    public boolean isValidSerial(String serial) {
        // Check basic format (xxx.xxx.xxx)
        if (!serial.matches("\\d{3}\\.\\d{3}\\.\\d{3}")) {
            return false;
        }

        // Split into three sets
        String[] sets = serial.split("\\.");

        // Check each set's constraints
        return isEvenSum(sets[0]) &&                 // First set sum must be even
                isOddSum(sets[1]) &&                  // Second set sum must be odd
                hasIncreasingLastDigit(sets[0]) &&    // Last digit must be largest
                hasIncreasingLastDigit(sets[1]) &&    // in each set
                hasIncreasingLastDigit(sets[2]);
    }

    private boolean isEvenSum(String set) {
        return getSum(set) % 2 == 0;
    }

    private boolean isOddSum(String set) {
        return getSum(set) % 2 != 0;
    }

    private int getSum(String set) {
        return set.chars()
                .map(Character::getNumericValue)
                .sum();
    }

    private boolean hasIncreasingLastDigit(String set) {
        int last = Character.getNumericValue(set.charAt(2));
        int first = Character.getNumericValue(set.charAt(0));
        int second = Character.getNumericValue(set.charAt(1));
        return last > first && last > second;
    }

    // Test cases
    public static void main(String[] args) {
        SerialNumberModular validator = new SerialNumberModular();
        runTestCases(validator);
    }

    private static void runTestCases(SerialNumberModular validator) {
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

            boolean result = validator.isValidSerial(serial);
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