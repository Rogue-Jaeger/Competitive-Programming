// https://leetcode.com/problems/find-all-duplicates-in-an-array

// My Approach: (Pigeon hole principle: We're given the integers of nums are in the range [1, n] or something like that.)
// Traverse all the indexes and try to swap the values to their dedicated place
// 1 should be at 0th index and 2 at the 2nd index
// So I remain swapping at the current index until the value at the current index is not swappable
// 1. The value at the current index already has the same value at the swappable index so I replace by -1 in current index and
// add it to the result
// 2. The current value is already -1.
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList();
        int i = 1;

        while (i <= nums.length) {
            if (nums[i - 1] != i && nums[i - 1] != -1) {
                // swap // if wefind the same number in nums[i] place then add 0 in i's place add value and move forward
                if (nums[nums[i - 1] - 1] == nums[i - 1]) {
                    // System.out.println("*" + i + " " + nums[i - 1]);
                    result.add(nums[i - 1]);
                    nums[i - 1] = -1;
                    i++;
                } else {
                    int temp = nums[i - 1]; // curr index pe 2 hai hona 3 chahiye
                    nums[i - 1] = nums[nums[i - 1] - 1]; // curr Index pe
                    nums[temp - 1] = temp;
                    // System.out.println("#" + i + " " + nums[i - 1] + " " + temp + " " + nums[temp - 1]);
                }
            } else {
                // System.out.println("&" + i + " " + nums[i - 1]);
                i++;
            }
        }

        return result;
    }
}

// Another Approach: (Not mine)
// Took advantage of "each integer appears at max twice" idea... Traverse the array and replace the replacable indexes value to
// negative of the number "-value" to indicate that this number is visited once and when from another index we get swappable value
// is in negative we assume that we have come here once so add it to the result.
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> dup = new ArrayList<>();

        for (int n : nums) {
            int ind = Math.abs(n) - 1;

            if (nums[ind] < 0) {
                dup.add(ind+1);
            } else {
                nums[ind] = -nums[ind];
            }
        }
        return dup;
    }
}
