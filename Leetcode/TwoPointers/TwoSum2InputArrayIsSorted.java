// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        while (end > start + 1) {
            if (numbers[start] + numbers[end] < target) start++;
            else if(numbers[start] + numbers[end] > target) end--;
            else break;
        }
        return new int[]{++start, ++end};
    }
}
