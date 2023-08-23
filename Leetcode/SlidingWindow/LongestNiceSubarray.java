// https://leetcode.com/problems/longest-nice-subarray

// Found 2 types of general solutions to sliding window and both of them are listed below:

/// TYPE - 1
// This solution consists of never decreasing the window meaning the gap between end and the current index will either
// remain constant or increase as we progress throught the array this gap denotes the max length of subarray at any point.
// The result at the end will just be nums.length - end.
class Solution {
    public int longestNiceSubarray(int[] nums) {
        int[] byteCount = new int[33];
        int num = 0, end = 0, totalBitsGreater = 0;

        for (int i = 0; i < nums.length; i++) {
            num = nums[i];
            for (int j = 1; j <= 32; j++) {
                if ((num >> j & 1) == 1) {
                    if (++byteCount[j] > 1) totalBitsGreater++;
                }
            }
            if (totalBitsGreater > 0) {
                for (int j = 1; j < 33; j++) {
                    if ((nums[end] >> j & 1) == 1) {
                        if (byteCount[j]-- > 1) totalBitsGreater--;
                    }
                }
                end++; // i - end will always be constant or increasing...
            }
        }

        return nums.length - end;
    }
}

/// TYPE - 2
// This type of sliding window approach consists of having a loop of some kind in between (while loop here) and the
// window can decrease as well so at any point in the array we calculate the max length of the window which we came across...
// The result at the end will be the max window size we obtained.
class Solution {
    public int longestNiceSubarray(int[] nums) {
        int result = Integer.MIN_VALUE, end = 0, agg = 0; // agg is aggregate of values in the subarray calculated by ORring all the values in
        // that sub array...
        for (int i = 0; i < nums.length; i++) {
            while ((agg & nums[i]) != 0) { // We need to first check if the value at current index is voilating the current subarray's
                // & condition or not. If it is voilating then we increate the end value while removing the element at the current end
                // from the aggregate by XORring it as one at each position came from **only one** integer in that subarray (We're building our subarray this way).
                agg ^= nums[end];
                end++;
            }
            agg |= nums[i]; // Just adding the current element to our subarray by just ORring it...
            result = Math.max(i - end + 1, result); // We need to maintain the max window size as it may shrink due to while loop above.
        }
        return result;
    }
}
