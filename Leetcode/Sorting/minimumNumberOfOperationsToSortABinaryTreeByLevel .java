// https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Logic is to swap and put in place the value currently on and move forward.
    private int minSwaps(Map<Integer, Integer> sorted, List<Integer> unsorted) {
        int i = 0, result = 0, tmp;
        for (Map.Entry<Integer, Integer> entry: sorted.entrySet()) {
            if (i != entry.getValue()) {
                sorted.put(unsorted.get(i), entry.getValue());
                tmp = unsorted.get(i);
                unsorted.set(i, unsorted.get(entry.getValue()));
                unsorted.set(entry.getValue(), tmp);
                entry.setValue(i);
                result++;
            }
            i++;
        }
        return result;
    }

    public int minimumOperations(TreeNode root) {
        List<TreeNode> bfs = new ArrayList();
        bfs.add(root); bfs.add(null);

        int i = 0;
        while(i < bfs.size() - 1) { // i < bfs.length will go in infinite loop.
            if (bfs.get(i) == null) bfs.add(null);
            else {
                if (bfs.get(i).left != null) bfs.add(bfs.get(i).left);
                if (bfs.get(i).right != null) bfs.add(bfs.get(i).right);
            }
            i++;
        }

        Map<Integer, Integer> sorted = new TreeMap();
        List<Integer> unsorted = new ArrayList();
        int result = 0;
        for (int j = 0; j < bfs.size(); j++) {
            if (bfs.get(j) == null) {
                result += minSwaps(sorted, unsorted);
                unsorted.clear(); sorted.clear();
            } else {
                unsorted.add(bfs.get(j).val); sorted.put(bfs.get(j).val, unsorted.size() - 1);
            }
        }

        return result;
    }
}
