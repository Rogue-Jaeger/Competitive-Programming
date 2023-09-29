// https://leetcode.com/problems/powx-n

// Idea is to just keep on updating multiplier on the side with the power of 2
// meaning everytime the loop runs its multiplied by itself
// 2 * 2 = 4
// 4 * 4 = 16
// 16 * 16 = 256
// and propogate it into result when we get a 1 from the operation of n >> 1

// Its >>>= not >>=
// Its better to do n = -n than n = n * -1

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (x == 0.0) return 0.0;

        double result = 1.0, multiplier = 1.0;

        if (n > 0) {
            multiplier = x;
        } else {
            n = n * -1;
            multiplier = 1/x;
        }

        while (n != 0) {
            if ((n & 1) == 1) result *= multiplier;
            multiplier *= multiplier;
            n >>>= 1;
        }

        return result;
    }
}

// Compacted code:
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 0) return 0;

        double result = 1;

        if (n < 0) {
            n = n * -1;
            x = 1/x;
        }

        while (n != 0) {
            if ((n & 1) == 1) result *= x;
            x *= x;
            n >>>= 1;
        }

        return result;
    }
}
