//https://leetcode.com/problems/wiggle-subsequence

// Solution coded by me
// Test case I missed: 1 - 2 - 2 - 2 - 3 should be treated as 2.
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int res = 1;
        byte previousDiff = (byte) 0;

        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] - nums[i - 1] > 0 && previousDiff != 1) || (nums[i] - nums[i - 1] < 0 && previousDiff != -1)) {
                res++;
            }

            if (nums[i] - nums[i - 1] == 0) continue;
            else previousDiff = nums[i] - nums[i - 1] > 0 ? (byte) 1 : (byte) -1;
        }

        return res;
    }
}

// Solution having good insight: Not coded by me.
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        int up=1,down=1;
        for(int i=1;i<n;i++)
        {
            if(nums[i-1]<nums[i])
                up=down+1;
            else if(nums[i-1]>nums[i])
                down=up+1;
        }
        return Math.max(up,down);
    }
}
