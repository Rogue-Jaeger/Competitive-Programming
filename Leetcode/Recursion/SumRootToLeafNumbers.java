// https://leetcode.com/problems/sum-root-to-leaf-numbers

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
    int currNumber = 0, result = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        currNumber = currNumber * 10 + root.val;
        sumNumbers(root.left);
        sumNumbers(root.right);
        if (root.left == null && root.right == null) result += currNumber;
        currNumber = currNumber / 10;
        return result;
    }
}

// Another good solution has less lines but requires more space on the heap.
// See how he's getting the sum from both left and right nodes.
class Solution {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode n, int s){
        if (n == null) return 0;
        if (n.right == null && n.left == null) return s*10 + n.val;
        return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
    }
}
