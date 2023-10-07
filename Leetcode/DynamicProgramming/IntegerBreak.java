// https://leetcode.com/problems/integer-break

// Learned how to apply the 1-D DP.

class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        int maxProduct;

        // Count values till the required value.
        for (int i = 2; i < dp.length; i++) {
            maxProduct = Integer.MIN_VALUE;
            // Calculating the max value for a index by checking out all the values from 1 * dp[i - i] to (i - j) *  dp[i - (i - j)]
            for (int j = 1; j <= i / 2; j++) {
                maxProduct = Math.max(
                        Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]), // Applying max function here because for 2 and 3 the
                        // combination values are less than their own values meaning dp[2] < 2 and dp[3] < 3.
                        maxProduct
                );
            }
            dp[i] = maxProduct;
        }

        // Last index will contain the result.
        return dp[n];
    }
}
