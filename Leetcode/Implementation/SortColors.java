//https://leetcode.com/problems/sort-colors/

import java.lang.Math;

class Solution {
    public void sortColors(int[] nums) {
//        initial approach:
//        stopped in midway as it was taking too much code
//                was maintaining 3 pointers to end of every value but actually need only 2
//            as 2 values will always end at last so we can discard it and
//                instead transform the end of 1 to start of 2

//        int[3] colorsEnd = {-1, -1, -1};
//
//        for(int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                colorsEnd[0]++;
//                nums[colorsEnd[0]] = 0;
//
//                if (colorsEnd[1] != -1) {
//                    colorsEnd[1]++;
//                    nums[colorsEnd[1]] = 1;
//                }
//
//                if (colorsEnd[2] != -1) {
//                    colorsEnd[2]++;
//                    nums[colorsEnd[2]] = 2;
//                }
//
//            } else if (nums[i] == 1) {
//
//                if (colorsEnd[1] == -1) {
//                    if (colorsEnd[2] != -1) {
//                        colorsEnd[1] = colorsEnd[0] + 1;
//                        nums[colorsEnd[1]] = 1;
//                        colorsEnd[2]++;
//                        nums[colorsEnd[2]] = 2;
//                    } else if (colorsEnd[])
//                }
//
//            } else {
//
//            }
//        }
        int endOf0 = -1, startOf2 = nums.length, temp;

        for(int i = 0; i < Math.min(nums.length, startOf2);) {
            if (nums[i] == 0 && endOf0 != i) {
                endOf0++;
                temp = nums[endOf0];
                nums[endOf0] = nums[i];
                nums[i] = temp;
            } else if (nums[i] == 2) {
                startOf2--;
                temp = nums[startOf2];
                nums[startOf2] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }
    }
}