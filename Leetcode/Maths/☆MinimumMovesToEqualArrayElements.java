/*
Problem: Minimum Moves to Make Array Elements Equal

Key Insight:
Instead of thinking about incrementing n-1 elements, we can think about decrementing one element.
This perspective shift makes the problem much simpler to solve.

Mathematical Solution:
The minimum moves required = sum(array) - (length * minimum_element)

Explanation:
1. Consider incrementing n-1 elements vs decrementing 1 element:
   - Both operations have the same relative effect on the array
   - If we increment all elements except A, the difference between A and others increases by 1
   - Similarly, if we just decrement A, we get the same relative difference

2. Using the decrement perspective:
   - All elements must eventually equal the minimum element
   - For each element: moves needed = current_value - minimum_value
   - Total moves = sum of all these differences
   - This gives us our formula: sum(array) - (length * minimum_element)

Example:
For array [1, 2, 6]:
- sum = 9
- length = 3
- min = 1
- moves = 9 - (3 * 1) = 6

Verification:
- 1 -> 1: 0 moves
- 2 -> 1: 1 move
- 6 -> 1: 5 moves
Total = 6 moves

Proof of Minimality:
Let m = moves, sum = array sum, n = length, min = minimum value
After m moves:
1. Final sum = sum + m(n-1) = nx (where x is final value)
2. Final value x = min + m
3. Solving these equations:
   sum + m(n-1) = n(min + m)
   sum - m = n * min
   m = sum - n * min

This proves there's only one possible value for m, making it the minimum.
*/

class Solution {
    public int minMoves(int[] nums) {
        int result = 0, min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                result += i * (min - nums[i]);
                min = nums[i];
            } else result += (nums[i] - min);
        }
        return result;
    }
}