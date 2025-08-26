// https://leetcode.com/problems/single-number-iii

class Solution {
    public int[] singleNumber(int[] nums) {
        int xorOf2Nums = 0;
        for (int i : nums) {
            xorOf2Nums ^= i;
        }
        int rightMostSetBit = (xorOf2Nums & -xorOf2Nums);
        int[] result = new int[2];
        for (int i : nums) {
            // Dividing the 2 unique numbers based on the differently set rightMostSetBit in xorOf2Nums.
            if ((i & rightMostSetBit) == 0) { // IMPPPP: While doing > 0 here was failing for test case [-1, Integer Max Value Test Case], == 0 is a much better condition.
            // Cause the resultant for (i & rightMostSetBit) = 10000000000000000000000000000000 even though it has 1 but its not a positive number.
                result[0] ^= i;
            } else {
                result[1] ^= i;
            }
        }
        return result;
    }
}
