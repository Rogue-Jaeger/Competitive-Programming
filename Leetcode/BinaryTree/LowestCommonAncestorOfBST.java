/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// But this solution is also not adequate as the time complexity of this is O(n) and we need O(log(n))
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null; // Forgot to add this...
        if (root.val >= Math.min(p.val, q.val) && root.val <= Math.max(p.val, q.val)) return root;
        TreeNode node = lowestCommonAncestor(root.left, p, q);
        if (node != null) return node;
        return lowestCommonAncestor(root.right, p, q);
    }
}

// This one has the time complexity of O(n)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        else if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
