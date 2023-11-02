// https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/description/?envType=daily-question&envId=2023-11-02

// Learned that instead of a class for the return type (i.e. AverageInfo here...) we can also return new int[2] to save some memory when (node == null)
// instead of returning null, Sample code written below my submission.

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
    int result = 0;

    public class AverageInfo {
        int sum;
        int count;
        public AverageInfo(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }

    public AverageInfo findNodesCount(TreeNode node) {
        if (node == null) return null;

        AverageInfo avgInfoLeft = findNodesCount(node.left);
        AverageInfo avgInfoRight = findNodesCount(node.right);


        int sumTillNow = (avgInfoLeft != null ? avgInfoLeft.sum : 0) + node.val + (avgInfoRight != null ? avgInfoRight.sum : 0);
        int countTillNow = (avgInfoLeft != null ? avgInfoLeft.count : 0) + 1 + (avgInfoRight != null ? avgInfoRight.count : 0);

        if (sumTillNow / countTillNow == node.val) result++;

        return new AverageInfo(sumTillNow, countTillNow);
    }

    public int averageOfSubtree(TreeNode root) {
        findNodesCount(root);
        return result;
    }
}

// Memory optimization:

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
    private int count;

    public int averageOfSubtree(TreeNode root) {
        count = 0;
        process(root);
        return count;
    }

    public int[] process(TreeNode node) {
        if (node == null) return new int[2];
        int[] prev = process(node.left);
        int[] next = process(node.right);
        int subCount = prev[0] + next[0] + 1;
        int subSum = prev[1] + next[1] + node.val;
        if (subSum / subCount == node.val) {
            count++;
        }
        prev[0] += next[0] + 1;
        prev[1] += next[1] + node.val;
        return prev;
    }
}
