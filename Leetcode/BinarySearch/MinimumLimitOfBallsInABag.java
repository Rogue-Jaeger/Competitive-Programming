// https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag

// Got to know how to use binary search in cases of finding min or max operations.
class Solution {
    private boolean canSupportOps(int[] nums, int targetBalls, int permittedOps) {
        int totalOps = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > targetBalls) {
                totalOps += (Math.ceil((double) nums[i] / targetBalls) - 1); // Writing (double) is important here otherwise ceil will get 1.0 in case of 3/2 instead of 1.5
                if (totalOps > permittedOps) {
                    return false;
                } 
            }
        }
        return true;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1, r = Arrays.stream(nums).max().getAsInt(), mid;

        while (l < r) {
            mid = l + (r - l) / 2;
            if (canSupportOps(nums, mid, maxOperations)) r = mid;
            else l = mid + 1;
        }

        return l;
    }
}
