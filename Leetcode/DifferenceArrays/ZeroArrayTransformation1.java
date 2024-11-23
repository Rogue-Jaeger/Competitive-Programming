// https://leetcode.com/problems/zero-array-transformation-i/description/

// Difference array is a technique used along with sweep lines algo.
// it basically supports range updates and point queries.
// Here point query is the final resultant loop we run at the very end to find the result. 
class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        // Here main reason why this approach works is because we're always decreasing the values
        // Otherwise the case which we're not handling is suppose a index is having value 1 and we do a -2 on it now it will become -1
        // but it should remain 0 now if we do a +5 on it the resultant will still be 4 but ideally it should be 5.  
        int[] diffArr = new int[nums.length];

        for (int[] query: queries) {
            diffArr[query[0]] -= 1;
            if (query[1] + 1 != nums.length) diffArr[query[1] + 1] += 1; // If we want to avoid this if create an array with nums.length + 1
        }

        // In this step we're calculating the final additions and subtractions that will happen to every index in the nums array
        // we're just doing a prefix sum here as we've stored the values in the previous for loop for it.
        int currMask = diffArr[0];
        for (int i = 1; i < nums.length; i++) { 
            currMask += diffArr[i];
            diffArr[i] = currMask;
        }

        // Finding if any value is greater than 0 after doing the additions and subtractions and returning if some value is found.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] + diffArr[i] > 0) return false;
        }

        return true;
    }
}
