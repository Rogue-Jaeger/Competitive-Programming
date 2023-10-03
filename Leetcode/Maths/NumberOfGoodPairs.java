// https://leetcode.com/problems/number-of-good-pairs

// My first approach calculate occurence of every element and calculate the combination at the end.
// Complexity is O(n)
class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> numsGroup = new HashMap();
        int result = 0;

        for (int num : nums) {
            numsGroup.put(num, numsGroup.getOrDefault(num, 0) + 1);
        }

        for (Integer group : numsGroup.values()) {
            if (group < 2) continue;
            result += (group * (group - 1)) / 2;
        }

        return result;
    }
}

// Second approach is whenever a new element comes it combines with all its previous ones so we add the combinations
// and the combinations will be the amount of elements before it.
// Complexity is O(n)
class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> numsGroup = new HashMap();
        int result = 0;

        for (int num : nums) {
            result += numsGroup.getOrDefault(num, 0);
            numsGroup.put(num, numsGroup.getOrDefault(num, 0) + 1);
        }

        return result;
    }
}
