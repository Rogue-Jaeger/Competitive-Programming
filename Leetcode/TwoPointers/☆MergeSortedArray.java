// https://leetcode.com/problems/merge-sorted-array

// This question is the one where if you don't know the trick right away then you can get in trouble.
// Was always thinking of filling up the array from front and the thing is where will I put the value if replaced?
// 1. Put it in the shorter arr -> Need to do 3 way comparison / May be feasible not sure.
// 2. Put it in the larger arr -> Need to do 3 way comparison.
//    a. Larger arr just at the starting of all the zeros. -> Will not be feasible.
//    b. From the end. -> May be feasible not sure.
// We need to come up with an approach where we need to make sure that whatever element we pick from arr1 or arr2 we need
// not replace any existing element which is relevant. Which takes us to putting the larger elements from the back.

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int filledIndex = m + n;
        int bigArrIndex = m - 1;
        int smallArrIndex = n - 1;

        while (filledIndex-- > 0) {
            if (bigArrIndex < 0 || smallArrIndex >= 0 && nums2[smallArrIndex] > nums1[bigArrIndex]) {
                nums1[filledIndex] = nums2[smallArrIndex--];
            } else {
                nums1[filledIndex] = nums1[bigArrIndex--];
            }
        }
    }
}
