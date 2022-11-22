//https://leetcode.com/problems/count-complete-tree-nodes/

//Binary search on second last row tree traversal.

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
    private int power(int exponent) {
        // 2 is the mantissa here
        int result = 1;
        while(exponent-- > 0) {
            result *= 2;
        }
        return result;
    }

    private int numberOfNodes(int height) {
        return power(height + 1) - 1;
    }

    private TreeNode getNode(int target, int length, int height, TreeNode node) {
        int start = 1, end = length, mid;

        while(height-- > 0) {
            mid = start + (end - start) / 2;

            if(mid < target) { // Messed up badly here yahan par <= condition nahi aayegi...
                node = node.right; // Messed up badly here did end = mid and node = node.left
                start = mid;
            } else {
                node = node.left;
                end = mid;
            }
        }
        
        return node;
    }

    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        // Best to keep root height as 0.
        TreeNode startNode = root, endNode = root, leftParent = null, midNode;
        int leftHeight = 0, rightHeight = 0;

        while(startNode.left != null) {
            leftParent = startNode;
            startNode = startNode.left;
            leftHeight++;
        }

        while(endNode.right != null) {
            endNode = endNode.right;
            rightHeight++;
        }


        if(leftHeight == rightHeight) return numberOfNodes(rightHeight);
        // below is the else condition
        startNode = leftParent;

        int start = 1, end = power(rightHeight), mid;

        while(end - start > 1) {
            mid = (end + start) / 2;

            midNode = getNode(mid, power(rightHeight), rightHeight, root);
            
            if(midNode.left != null && midNode.right == null) {
                return numberOfNodes(rightHeight) + 2 * (mid - 1) + 1; //mid + 1 - 1 = mid
            }

            if(midNode.left == null) {
                endNode = midNode;
                end = mid;
            } else {
                startNode = midNode;
                start = mid;
            }

        }
        

        return numberOfNodes(rightHeight)
            + 2 * (start - 1) // start + 1 - 1 = start
            + (startNode.left != null ? 1 : 0)
            + (startNode.right != null ? 1 : 0)
            + (endNode.left != null && startNode != endNode ? 1 : 0) // Got issue with case [1,2] as here start = 1 and end = 1.
            + (endNode.right != null && startNode != endNode ? 1 : 0); // That is why condition '&& startNode != endNode'

    }
}
