// https://leetcode.com/problems/kth-smallest-element-in-a-bst

/*
Create a BST
                        9
                       / \
                      3   10
                     / \
                    2   6
                   /   / \
                  1   5   7
                     /     \
                    4       8
Now the influx and outflux of count looks like the following:

      in-3      out-8
            (6)
  in-3 out-5    in-6 out-8

-------------------------------

      in-3      out-5
            (5)
  in-3 out-4    in-5 out-5


The algo is that if the node is null return the count till now
get count from the left child
add the current count if its equal to what we want then put it in result
if not add the current node to the result and pass it into the right child
and return whatever we've got from the right child
*/


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
    private int result = -1;

    private int getKthSmallest(TreeNode node, int k, int currentCount) {
        if (result > -1 || node == null) return currentCount;
        int countFromLeftChild = getKthSmallest(node.left, k, currentCount);
        if (countFromLeftChild + 1 == k) result = node.val;
        return getKthSmallest(node.right, k, countFromLeftChild + 1);
    }

    public int kthSmallest(TreeNode root, int k) {
        getKthSmallest(root, k, 0);
        return result;
    }
}
