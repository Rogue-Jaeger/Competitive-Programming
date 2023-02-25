// https://leetcode.com/problems/subsets/submissions/904798125/

class Solution {
    private int[] arr;
    private List<List<Integer>> res = new ArrayList();
    // By avoiding passing "res" in function saved a bit on memory and runtime so the solution beats 100%.

    private void generate(List<Integer> currArr, int currIndex) {
        if (currIndex == arr.length) return;

        for(int i = currIndex; i < arr.length; i++) { // This contains the main logic.
            List<Integer> k = new ArrayList(currArr);
            k.add(arr[i]);
            res.add(k);
            generate(k, i + 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        arr = nums;

        generate(new ArrayList(),  0);
        res.add(new ArrayList());

        return res;
    }
}
