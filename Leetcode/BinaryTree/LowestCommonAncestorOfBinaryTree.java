// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return null;
        TreeNode leftResult = lowestCommonAncestor(node.left, p, q);
        TreeNode rightResult = lowestCommonAncestor(node.right, p, q);
        if (node == p || node == q || (leftResult != null && rightResult != null)) return node;
        if (leftResult != null) return leftResult;
        return rightResult;
    }
}

// Can be compressed further to this, Nor written by me:
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    return left == null ? right : right == null ? left : root;
}
