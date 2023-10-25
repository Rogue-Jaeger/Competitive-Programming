// https://leetcode.com/problems/minimum-sum-of-mountain-triplets-ii

// Its a graph type problem where I usually mark a point for every index and analyse the peaks and troughs... But for this
// nothing works as the triplets forming ^ shape doesn't matter here as for this arr [1,2,3,4,5,1] the solution will be
// 1,2,1 so the ^ shape doesn't matter here. Here just as the question has mentioned calculated the min from left and
// where its index is present and min from right and where its index is present.
// Learning: Graph type questions doesn't always have graph type solutions.

class Solution {
    public int minimumSum(int[] nums) {
        int[] minIndexLeft = new int[nums.length];
        int[] minIndexRight = new int[nums.length];
        int result = Integer.MAX_VALUE;

        for (int i = 0, minIndex = 0; i < nums.length; i++) {
            if (nums[i] - nums[minIndex] <= 0) {
                minIndex = i;
            }
            minIndexLeft[i] = minIndex;
        }

        for (int i = nums.length - 1, minIndex = nums.length - 1; i >= 0; i--) {
            if (nums[i] - nums[minIndex] <= 0) {
                minIndex = i;
            }
            minIndexRight[i] = minIndex;
        }

        for (int i = 0; i < nums.length; i++) {
            if (minIndexLeft[i] != i && minIndexRight[i] != i && result > nums[minIndexLeft[i]] + nums[minIndexRight[i]] + nums[i]) {
                result = nums[minIndexLeft[i]] + nums[minIndexRight[i]] + nums[i];
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
