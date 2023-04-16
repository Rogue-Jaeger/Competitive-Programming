// https://leetcode.com/problems/recover-binary-search-tree/

// First approach was to just find the first anomaly and swap and return...
// Case: [2,3,1] breaks this
// Code is below:

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
    boolean swapFound = false;

    void solve(TreeNode node, TreeNode leftBound, TreeNode rightBound) {
        if (swapFound) return;
        if (node.val < leftBound.val || node.val > rightBound.val) {
            int temp;
            if (node.val < leftBound.val) {
                temp = leftBound.val;
                leftBound.val = node.val;
                node.val = temp;
            } else {
                temp = rightBound.val;
                rightBound.val = node.val;
                node.val = temp;
            }
            swapFound = true;
            return;
        }

        if (node.left != null) solve(node.left, leftBound, node);
        if (node.right != null) solve(node.right, node, rightBound);

    }

    public void recoverTree(TreeNode root) {
        solve(
                root,
                new TreeNode(Integer.MIN_VALUE),
                new TreeNode(Integer.MAX_VALUE)
        );
    }
}

// Second approach was to just let this run and swap twice which also won't work...

// Third approach was to traverse through inorder traversal (Array will be sorted) and find anomalies and replace them
// Insight here is that if there is a swap greater integer will be present to the right of a smaller integer...
// So in the array there can be 1 or 2 anomaly meaning
// 1 3 2 4 -> here is one anomaly as we need to replace just 3 with 2 which are adjacent...
// 3 2 1 -> here will be 2 anomalies as 3 and 1 have 2 in between so we consider them 2 anomalies as we have to handle it the second time.
// So first time we get anomaly we update firstAnomaly and secondAnomaly
// Second time we get anomaly we just update secondAnomaly
// The reason we need prevNode is the condition we apply is less than so for comparison we need previousNode as well.

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
    TreeNode prevNode = new TreeNode(Integer.MIN_VALUE), firstAnomaly, secondAnomaly;

    // Doing inorder traversal...
    void solve(TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            if (prevNode.val > node.val) {
                if (firstAnomaly == null) {
                    firstAnomaly = prevNode;
                    secondAnomaly = node;
                }
                else secondAnomaly = node;
            }
            prevNode = node;
            return;
        }

        solve(node.left);

        if (prevNode.val > node.val) {
            if (firstAnomaly == null) {
                firstAnomaly = prevNode;
                secondAnomaly = node;
            }
            else secondAnomaly = node;
        }
        prevNode = node;

        solve(node.right);
    }

    public void recoverTree(TreeNode root) {
        solve(root);
        int temp = firstAnomaly.val;
        firstAnomaly.val = secondAnomaly.val;
        secondAnomaly.val = temp;
    }
}

// Code optimised...

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
    TreeNode prevNode = new TreeNode(Integer.MIN_VALUE), firstAnomaly, secondAnomaly;

    // Doing inorder traversal...
    void solve(TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            if (prevNode.val > node.val) {
                if (firstAnomaly == null) firstAnomaly = prevNode;
                secondAnomaly = node;
            }
            prevNode = node;
            return;
        }

        solve(node.left);

        if (prevNode.val > node.val) {
            if (firstAnomaly == null) firstAnomaly = prevNode;
            secondAnomaly = node;
        }
        prevNode = node;

        solve(node.right);
    }

    public void recoverTree(TreeNode root) {
        solve(root);
        int temp = firstAnomaly.val;
        firstAnomaly.val = secondAnomaly.val;
        secondAnomaly.val = temp;
    }
}
