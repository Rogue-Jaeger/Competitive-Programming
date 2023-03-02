// https://leetcode.com/problems/permutations

// My initial solution: Worked fine.
class Solution {
    List<List<Integer>> solution = new ArrayList();

    private void solve(List<Integer> nums, List<Integer> result) {
        if (nums.size() == 0) {
            solution.add(new ArrayList(result));
            return;
        }

        for(int i = 0; i < nums.size(); i++) {
            result.add(nums.get(i));
            List<Integer> newArr = new ArrayList(nums);
            newArr.remove(i);
            solve(newArr, result);
            result.remove(result.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        // Arrays.asList(nums) will not work as nums is int[] not Integer[]
        solve(Arrays.stream(nums).boxed().collect(Collectors.toList()), new ArrayList());
        return solution;
    }
}

// Solution optimised for memory by swapping.
class Solution {
    List<List<Integer>> solution = new ArrayList();
    int[] numbers;

    private void swap(int firstIndex, int secondIndex) {
        int temp = numbers[firstIndex];
        numbers[firstIndex] = numbers[secondIndex];
        numbers[secondIndex] = temp;
    }

    private void solve(int startIndex, List<Integer> result) {
        if (startIndex == numbers.length) {
            solution.add(new ArrayList(result));
            return;
        }

        for(int i = startIndex; i < numbers.length; i++) {
            result.add(numbers[i]);
            swap(startIndex, i);
            solve(startIndex + 1, result);
            swap(i, startIndex);

            result.remove(result.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        numbers = new int[nums.length];
        numbers = nums.clone();
        solve(0, new ArrayList());
        return solution;
    }
}

// To optimise memory further if all the elements in the array are unique then instead of swapping we can just
// use this if condition inside to not pick elements that are already picked in the contains list.
if (currentList.contains(nums[i])) {
    continue;
}
