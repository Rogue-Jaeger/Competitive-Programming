// https://leetcode.com/problems/longest-common-subsequence/

// The first solution which I came up with myself after I couldn't think of anything at all
// There is most probably no other way to proceed with question apart from 2D DP
// 2D dp isn't intuitive at all I came up with this by drawing 2d matrix and figuring out the corrlations 
// between different cells.
// The solution involves generating the matrix of the length of both the strings and handling special cases for 
// when if i == 0 or j == 0.
// The solution works by looking at the cells i - 1, j - 1 and i - 1, j and i, j - 1
// For i - 1, j - 1 if the new characters are the same then increase the value by one and add to cell i, j
// Or pick max from i - 1, j or i, j - 1.

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] lcsLength = new int[text1.length()][text2.length()];
        int maxSize;
        
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (i == 0) {
                    // Won't be able to do j - 1 here as if we want to remove the substring condition as you will see in the 
                    // later iterations.
                    lcsLength[i][j] = text2.substring(0, j + 1).indexOf(text1.charAt(0)) == -1 ? 0 : 1; 
                } else if (j == 0) {
                    lcsLength[i][j] = text1.substring(0, i + 1).indexOf(text2.charAt(0)) == -1 ? 0 : 1;
                } else {
                    maxSize = lcsLength[i - 1][j - 1] + (text1.charAt(i) == text2.charAt(j) ? 1 : 0);
                    maxSize = Math.max(maxSize, lcsLength[i - 1][j]);
                    maxSize = Math.max(maxSize, lcsLength[i][j - 1]);
                    lcsLength[i][j] = maxSize;
                }
            }
        }

        return lcsLength[lcsLength.length - 1][lcsLength[0].length - 1];
    }
}

// Third iteration is a slight modification of the above we just want to eliminate the if else loops so we need to 
// add handling for the first row and column how do we do that is by taking the 2D array of length text1 + 1, text2 + 1
// this also takes care of the substring condition as now we can take up the values from j - 1 as we have an extra column.

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] lcsLength = new int[text1.length() + 1][text2.length() + 1];
        int maxSize;
        
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) { // Just eliminated the if else loops here...
                maxSize = lcsLength[i - 1][j - 1] + (text1.charAt(i - 1) == text2.charAt(j - 1) ? 1 : 0);
                maxSize = Math.max(maxSize, lcsLength[i - 1][j]);
                maxSize = Math.max(maxSize, lcsLength[i][j - 1]);
                lcsLength[i][j] = maxSize;
            }
        }

        return lcsLength[lcsLength.length - 1][lcsLength[0].length - 1];
    }
}

// Now in the third iteration we basically apparantly use the insight that if both of the new characters are the same
// Then they'll yield the max result so it gets rid of doing max of all the 3 cells and now we got rid of 
// some computation and one variable as well. 

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] lcsLength = new int[text1.length() + 1][text2.length() + 1];
        
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    lcsLength[i][j] = lcsLength[i - 1][j - 1] + 1;
                } else {
                    lcsLength[i][j] = Math.max(lcsLength[i - 1][j], lcsLength[i][j - 1]);
                }
            }
        }

        return lcsLength[lcsLength.length - 1][lcsLength[0].length - 1];
    }
}

// The fourth itration will result in reducing the space complexity as well.. We will be using 1D array instead of 2D.
// We can see that for calculating value for a cell we just need the values from the row above and from the current one
// So we can just keep 2 rows (curent and prev) which would yield in 2 * O(N) space complexity.
// The swapping can be done like so:
// int[] temp = prev;
// prev = curr;
// curr = prev;
//
// Now if we want to further remove one of the 2 rows this is how we can do this:
// i - 1, j - 1 => We can keep a variable to track this value.
// i - 1, j => This value is already present at the current cell.
// i, j - 1 => This value is the value of the previous cell which was generated earlier.
// Find the code for this below:

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[] dp = new int[text2.length() + 1];
        int prevDiagonalValue, temp;

        for (int i = 1; i <= text1.length(); i++) {
            prevDiagonalValue = 0; // This is something I missed.
            for (int j = 1; j <= text2.length(); j++) {
                temp = dp[j]; // Capturing the value here.
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = prevDiagonalValue + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prevDiagonalValue = temp; // Setting it here.
            }
        }

        return dp[dp.length - 1];
    }
}
