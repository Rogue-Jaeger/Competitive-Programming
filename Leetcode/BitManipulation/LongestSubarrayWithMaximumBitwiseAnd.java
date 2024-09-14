// https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and

// The AND operation between 2 integers can never result in a number bigger than
// both of them. (This property is true for positive integers will have to check for negetive.)

class Solution {
    public int longestSubarray(int[] nums) {
        int maxCount = 1, count = 1, maxAndInt = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxAndInt) {
                maxCount = 1; count = 1; maxAndInt = nums[i];
            } else if ((nums[i] & nums[i - 1]) == maxAndInt) {
                count++; maxCount = Math.max(count, maxCount);
            } else {
                count = 1;
            }
        }

        return maxCount;
    }
}
