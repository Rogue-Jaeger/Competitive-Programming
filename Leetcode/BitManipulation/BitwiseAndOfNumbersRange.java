// https://leetcode.com/problems/bitwise-and-of-numbers-range

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int pow = 1, diff = right - left, result = 0;

        for (int i = 0; i < 32; i++) {
            if (
                // ((left >> 1) & 1) == 1
                    (left & 1) == 1
                            // && ((right >> 1) & 1) == 1
                            && (right & 1) == 1
                            && diff < pow
            ) {
                result += pow;
            }
            pow *= 2; // Its better to shift a single bit to left rather than multiplying it by 2
            left = left >> 1;
            right = right >> 1;
        }

        return result;
    }
}
