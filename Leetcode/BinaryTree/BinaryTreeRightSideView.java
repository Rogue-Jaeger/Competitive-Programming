// https://leetcode.com/problems/binary-tree-right-side-view

// The key is to just traverse normally and make sure the left side child node is called before right side child node.
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
    List<Integer> result = new LinkedList();

    private void generateRightSideView(TreeNode root, int level) {
        if (root == null) return;
        if (result.size() - 1 < level) result.add(root.val);
        else result.set(level, root.val);
        generateRightSideView(root.left, level + 1);
        generateRightSideView(root.right, level + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        generateRightSideView(root, 0);
        return result;
    }
}
