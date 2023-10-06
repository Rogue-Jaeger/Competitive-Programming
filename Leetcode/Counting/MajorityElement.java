// https://leetcode.com/problems/majority-element

// Learned how to count element with occurrence more than floor(n/2) with rumtime complexity O(N) and space complexity O(1).
// In this type of approach we need to do 2 loops one to get the max occuring element and the other one to check if
// its occurrence is more than floor(n/2).

class Solution {
    public int majorityElement(int[] nums) {
        int maxElementVal = 0, maxElementCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (maxElementCount == 0) {
                maxElementVal = nums[i];
                maxElementCount++;
            } else if (maxElementVal == nums[i]) {
                maxElementCount++;
            } else {
                maxElementCount--;
            }
        }

        return maxElementVal;
    }
}
