// https://leetcode.com/problems/max-consecutive-ones-iii

// The idea is to traverse the array normally through for loop and maintain a variable end which
// when substracted with the current position in for loop at any random position will give the value
// of maximum substring that can be built using the constraints of any question.

class Solution {
    public int longestOnes(int[] nums, int k) {
        int end = 0;
        int frequencyOfZero = 0;

        for (int num : nums) {
            if (num == 0) frequencyOfZero++;

            if (frequencyOfZero > k) {
                if (nums[end] == 0) frequencyOfZero--;
                end++; // We can remove this and add to the above if condition like nums[end++]
                // and then we can optimize further by clubbing the 2 if statements...
            }
        }

        return nums.length - end;
    }
}

// We can optimize it further by reusing k.
 public int longestOnes(int[] A, int K) {
    int i = 0, j;
    for (j = 0; j < A.length; ++j) {
        if (A[j] == 0) K--;
        if (K < 0 && A[i++] == 0) K++;
    }
    return j - i;
}
