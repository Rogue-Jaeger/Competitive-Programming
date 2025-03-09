// https://leetcode.com/problems/subarray-sums-divisible-by-k/

// This algorithm runs on mod arrays meaning to group preexisting sums into K buckets
// in such a way that meaningful insights can be drawn from them.

// Why are we adding K in modulo operations?
// int prefixSum = -5;
// int k = 3;

// System.out.println(-5 % 3);  // Output: -2  (Incorrect for indexing)
// System.out.println((-5 % 3 + 3) % 3);  // Output: 1 (Correct)

// Below was my initial solution which didn't pass:

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] mods = new int[k];
        int[] prefixSums = new int[nums.length];
        int result = 0;

        prefixSums[0] = nums[0]; 
        for (int i = 1; i < nums.length; i++) {
            prefixSums[i] = nums[i] + prefixSums[i - 1]; // Values exceeding k here.
        }

        for (int i = 0; i < nums.length; i++) {
            if (prefixSums[i] % k == 0) {
                mods[0]++;
                result += mods[0];
            } else {
                result += mods[prefixSums[i] % k]; // Prefix sums can become -ve as well no handling.
                mods[prefixSums[i] % k]++;
            }
        }
        return result;
    }
}

// This was one of the final solutions:

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] mods = new int[k];
        int[] prefixSums = new int[nums.length];
        int result = 0;

        prefixSums[0] = nums[0]; 
        for (int i = 1; i < nums.length; i++) {
            prefixSums[i] = nums[i] + prefixSums[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (prefixSums[i] % k == 0) {
                mods[0]++;
                result += mods[0];
            } else {
                result += mods[(prefixSums[i] % k + k) % k]; // Adding % k and + k
                mods[(prefixSums[i] % k + k) % k]++;
            }
        }
        return result;
    }
}
