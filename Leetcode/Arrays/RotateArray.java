// https://leetcode.com/problems/rotate-array

// There're 2 ways to rotate an array clockwise or anticlockwise and both yield separate results.
// The solution is with O(1) extra space.
// Divide the array into 2 sections and start setting the correct values to the right sections rightmost indexes.
// Then decrease the length of the lengthiest section with the other's length.

class Solution {
    private void swap(int[] nums, int firstIndex, int secondIndex) {
        int temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;
    }

    private void getRotatedArr(int[] nums, int leftSectionLength, int rightSectionLength) {
        if (leftSectionLength == 0 || rightSectionLength == 0) return;

        int min = Math.min(leftSectionLength, rightSectionLength);

        for (int i = 0; i < min; i++) {
            swap(nums, leftSectionLength - i - 1, rightSectionLength + leftSectionLength - i - 1);
        }

        getRotatedArr(
                nums,
                leftSectionLength > rightSectionLength ? leftSectionLength - min : leftSectionLength,
                leftSectionLength > rightSectionLength ? rightSectionLength : rightSectionLength - min
        );
    }

    public void rotate(int[] nums, int k) {
        // Pay attention here, jumbled up the param 2 with 3 initially...
        getRotatedArr(nums,  nums.length - k % nums.length, k % nums.length);
    }
}

// Unnecessary use of Math.min() removed.
class Solution {
    private void swap(int[] nums, int firstIndex, int secondIndex) {
        int temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;
    }

    private void getRotatedArr(int[] nums, int leftSectionLength, int rightSectionLength) {
        if (leftSectionLength == 0 || rightSectionLength == 0) return;

        boolean isLeftSectionShorter = leftSectionLength < rightSectionLength;

        for (int i = 0; i < (isLeftSectionShorter ? leftSectionLength : rightSectionLength); i++) {
            swap(nums, leftSectionLength - i - 1, rightSectionLength + leftSectionLength - i - 1);
        }

        getRotatedArr(
                nums,
                isLeftSectionShorter ? leftSectionLength : leftSectionLength - rightSectionLength,
                isLeftSectionShorter ? rightSectionLength - leftSectionLength : rightSectionLength
        );
    }

    public void rotate(int[] nums, int k) {
        // Pay attention here, jumbled up the param 2 with 3 initially...
        getRotatedArr(nums,  nums.length - k % nums.length, k % nums.length);
    }
}
