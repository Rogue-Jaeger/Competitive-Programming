// https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag

// The below solution will give time limit exceeded.
// This was the most optimized solution I could come up with with complexity of nlog(n)
// Even though the required complexity is the same I believe the Integer array introduction in the priority queue degrades the runtime performance.
// Please look at the file with the same name for its binary search approach which is passing the tests.
class Solution {
    private int getMaxValInBag(int[] nums, int divisor, int i) {
        return nums[i] % divisor > 0 ? (nums[i] / divisor) + 1 : (nums[i] / divisor);
    }

    public int minimumSize(int[] nums, int maxOperations) {
        PriorityQueue<Integer[]> pq = new PriorityQueue(
            (a, b) -> (((Integer[]) b)[0] - ((Integer[]) a)[0]) // Here if type casting is applied on the lambda arguments it'll give error.
        );

        for (int i = 0; i < nums.length; i++) {
            pq.add(new Integer[]{nums[i], i, 1}); // Will ensure to keep one element for each index of nums in the pq.
        }

        Integer[] maxVal;
        int index, result = 1;

        while (maxOperations > 0) {
            maxVal = pq.poll(); // Remove the top element.
            index = maxVal[1];
            maxVal[2]++;
            pq.add(new Integer[]{getMaxValInBag(nums, maxVal[2], index), index, maxVal[2]});
            maxOperations--;
        }
 
        return pq.poll()[0]; // Return the remaining top element.
    }
}
