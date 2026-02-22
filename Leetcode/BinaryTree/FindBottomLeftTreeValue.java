// https://leetcode.com/problems/find-bottom-left-tree-value

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
    int bottomLeftValue = 0, maxLevel = 0;

    private void findBottomLeftValue(TreeNode node, int level) {
        if (node == null) return;
        if (level > maxLevel) {
            bottomLeftValue = node.val;
            maxLevel = level;
        }
        findBottomLeftValue(node.left, level + 1);
        findBottomLeftValue(node.right, level + 1);
    }

    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root, 1);
        return bottomLeftValue;
    }
}
