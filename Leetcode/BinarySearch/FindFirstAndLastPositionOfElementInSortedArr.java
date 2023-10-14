// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[] {-1, -1};
        int left = 0, right = nums.length - 1, mid;

        while (left < right) {
            mid = left + (right - left) / 2; // Divide by 2 can also be done as >> 1.

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (nums[left] != target) { // If start for a number is not found then it doesn't exist.
            return new int[] {-1, -1};
        }

        int[] result = new int[2];
        result[0] = left; right = nums.length - 1;

        while (left < right) { // This can be removed and the above while loop can be used if we update the target itself (target = target + 1).
            mid = left + (right - left) / 2;

            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1; // By default left will go towards right.
            }
        }

        result[1] = nums[right] == target ? right : right - 1;

        return result;
    }
}
