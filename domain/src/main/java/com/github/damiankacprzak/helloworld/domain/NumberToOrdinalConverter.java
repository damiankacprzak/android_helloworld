package com.github.damiankacprzak.helloworld.domain;

public class NumberToOrdinalConverter {
    public static String toOrdinal(int cardinal) {
        if (cardinal <= 0) {
            throw new IllegalArgumentException("Cardinal number must be positive.");
        } else {
            return applySuffixTo(cardinal);
        }
    }

    private static String applySuffixTo(int cardinal) {
        int lastDigit = cardinal % 10;
        int last2Digits = cardinal % 100;

        String suffix;

        // case where final digit not control the suffix
        if (last2Digits >= 11 && last2Digits <= 13) {
            suffix = "th";
        } else {
            switch (lastDigit) {
                case 1:
                    suffix = "st";
                    break;
                case 2:
                    suffix = "nd";
                    break;
                case 3:
                    suffix = "rd";
                    break;
                default:
                    suffix = "th";
                    break;
            }
        }

        return cardinal + suffix;
    }
}
