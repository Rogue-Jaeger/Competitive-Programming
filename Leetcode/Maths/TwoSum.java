// https://leetcode.com/problems/two-sum/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> prevNumber = new HashMap();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (prevNumber.get(target - nums[i]) != null) {
                result[0] = prevNumber.get(target - nums[i]);
                result[1] = i;
                return result;
            }

            prevNumber.put(nums[i], i);
        }

        return new int[2]; // Redundant as the solution is guarantee.
    }
}
