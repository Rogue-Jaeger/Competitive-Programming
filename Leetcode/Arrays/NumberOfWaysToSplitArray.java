//https://leetcode.com/problems/number-of-ways-to-split-array

class Solution {
    public int waysToSplitArray(int[] nums) {
        long sumFromFront = 0, totalSum = 0;
        int res = 0;

        // for (int val : nums) totalSum += val; 
        // Shorthand is slower than using general for loop like used below.
        // See submissions.
        for (int i = 0; i < nums.length; i++) totalSum += nums[i];

        for (int i = 0; i < nums.length - 1; i++) {
            sumFromFront += nums[i];
            if (sumFromFront >= totalSum - sumFromFront) res++;
        }

        return res;
    }
}
