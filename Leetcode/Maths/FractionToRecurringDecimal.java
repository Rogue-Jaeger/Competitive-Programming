// https://leetcode.com/problems/fraction-to-recurring-decimal

// Idea is to just focus on remainder and store current position in the string along with it once its found again
// add "(" before it and ")" at the end.

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        long absNumerator = Math.abs((long) numerator); // Because Math.abs(Integer.MIN_VALUE) doesn't exist.
        long absDenominator = Math.abs((long) denominator); // Because Math.abs(Integer.MIN_VALUE) doesn't exist.

        long quotient = absNumerator / absDenominator, remainder = absNumerator % absDenominator;

        result.append(((numerator > 0) ^ (denominator > 0) ? "-" : "") + quotient);

        if (remainder == 0) return result.toString();

        result.append(".");

        Map<Long, Integer> remainderMap = new HashMap();

        while (remainder != 0) {
            remainderMap.put(remainder, result.length());
            remainder *= 10;
            quotient = remainder / absDenominator;
            result.append(quotient);
            if (quotient != 0) {
                remainder %= absDenominator;
            }
            if (remainderMap.containsKey(remainder)) {
                result.insert(remainderMap.get(remainder), "(");
                result.append(")");
                break;
            }
        }

        return result.toString();
    }
}
