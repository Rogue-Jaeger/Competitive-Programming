// https://leetcode.com/problems/search-insert-position

class Solution {
    public int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length - 1]) return nums.length;
        if (target < nums[0]) return 0;

        int right = nums.length - 1, left = 0, mid;

        while (right - left > 1) {
            if (nums[left] == target) return left;
            if (nums[right] == target) return right;

            mid = (left + right) / 2;

            if (nums[mid] <= target) left = mid;
            else right = mid;
        }

        if (nums[left] == target) return left;
        if (nums[right] == target) return right;

        return right;
    }
}


// More optimised approach below...

class Solution {
    public int searchInsert(int[] nums, int target) {
        int right = nums.length - 1, left = 0, mid;

        while (left <= right) {
            // we want left to go beyond right if not found
            // in case of lowest value not available in the array: left = 0 and right = -1
            // in case of highest value not available in the array: left = length and right = length - 1

            mid = (left + right) / 2;

            if (nums[mid] == target) return mid;

            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return left;
    }
}