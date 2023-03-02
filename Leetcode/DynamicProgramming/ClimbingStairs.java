// https://leetcode.com/problems/climbing-stairs/submissions/906648728/

// Recursive solution but too slow.
class Solution {
    int totalSteps = 0, ways = 0;

    public void countSteps(int climbedSteps) {
        if (climbedSteps >= totalSteps) {
            if (climbedSteps == totalSteps) ways++;
            return;
        }

        countSteps(climbedSteps + 1);
        countSteps(climbedSteps + 2);
    }

    public int climbStairs(int n) {
        totalSteps = n;
        countSteps(0);
        return ways;
    }
}

// DP solution using array.
class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;

        int[] ways = new int[n];
        ways[0] = 1;
        ways[1] = 2;

        for (int i = 2; i < n; i++)
            ways[i] = ways[i - 1] + ways[i - 2]; // instead of creating arrays can create variables as well.

        return ways[n - 1];
    }
}

//DP solution using variables to save space.
class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int a = 1, b = 2, res = 0;

        for (int i = 1; i < n - 1; i++) {
            res = a + b;
            a = b;
            b = res;
        }

        return res;
    }
}
