// https://leetcode.com/problems/binary-tree-level-order-traversal

// My first approach was to just do it with queues... The recursive way didn't come to mind.
// Read below for findings.
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> parent = new LinkedList();
        LinkedList<TreeNode> children = new LinkedList();
        List<List<Integer>> result = new ArrayList();

        if (root != null) parent.add(root);
        int index = 0;

        while (parent.size() != 0) {
            List<Integer> level = new ArrayList();
            while (parent.size() != 0) {
                if (parent.getFirst().left != null) children.add(parent.getFirst().left); // Learned about getFirst();
                if (parent.getFirst().right != null) children.add(parent.getFirst().right);
                level.add(parent.pop().val); // We also have removeFirst() as well which is same.
            }
            parent = children;
            children = new LinkedList();
            result.add(level);
        }

        return result;
    }
}

// The recursive approach: Learnings are that its less lengthy to write and gives better time complexity.
class Solution {
    List<List<Integer>> result = new ArrayList(); // Declared globally...

    private void generateLevelOrder(TreeNode node, int level) {
        if (node == null) return;
        if (level >= result.size()) result.add(new ArrayList());
        result.get(level).add(node.val);
        if (node.left != null) generateLevelOrder(node.left, level + 1);
        if (node.right != null) generateLevelOrder(node.right, level + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        generateLevelOrder(root, 0);
        return result;
    }
}
