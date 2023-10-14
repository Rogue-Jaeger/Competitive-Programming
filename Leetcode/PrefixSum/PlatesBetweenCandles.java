// https://leetcode.com/problems/plates-between-candles

// Test case that I failed:
// "|*|"
// query = {0, 2}
// Right of 0th index would be 2 and left of 2nd index is 0 so according to logic right != left will fail here
// So to fix this need to consider current indexes '|' as well for right and left.

// Test case that I missed:
// "|*|"
// query {2, 2}
// Now right of 2 will not have a proper value and adding that value is a hassle as well so added: queries[i][0] != queries[i][1]
// to resolve this issue.

class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] leftCandle = new int[s.length()];
        int[] rightCandle = new int[s.length()];
        int[] prefixSumCandles = new int[s.length()];
        int[] result = new int[queries.length];

        prefixSumCandles[0] = s.charAt(0) == '|' ? 1 : 0;

        for (int i = 1, j = s.length() - 2; i < s.length(); i++, j--) {
            leftCandle[i] = s.charAt(i) == '|' ? i : leftCandle[i - 1]; // Here treating current '|' as well for left.
            rightCandle[j] = s.charAt(j) == '|' ? j : rightCandle[j + 1]; // Here treating current '|' as well for right.
            prefixSumCandles[i] = s.charAt(i) == '|' ? prefixSumCandles[i - 1] + 1 : prefixSumCandles[i - 1];
        }

        for (int i = 0; i < queries.length; i++) {
            if (rightCandle[queries[i][0]] < leftCandle[queries[i][1]] && queries[i][0] != queries[i][1]) {
                result[i] = leftCandle[queries[i][1]] - rightCandle[queries[i][0]] - prefixSumCandles[leftCandle[queries[i][1]]] + prefixSumCandles[rightCandle[queries[i][0]]];
            } else {
                result[i] = 0;
            }
        }

        return result;
    }
}
