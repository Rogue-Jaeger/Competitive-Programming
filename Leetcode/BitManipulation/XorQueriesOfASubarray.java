// https://leetcode.com/problems/xor-queries-of-a-subarray

// XOR operation can be used in the problem types of prefix sums.
// Below solution clearly imitates a prefix sum solution but instead
// of addition and substration we're just using XOR operation.
// See BitManipulation.md file for more info.

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] ^ arr[i];
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == 0) {
                result[i] = arr[queries[i][1]];
                continue;
            }
            result[i] = arr[queries[i][0] - 1] ^ arr[queries[i][1]];
        }

        return result;
    }
}
