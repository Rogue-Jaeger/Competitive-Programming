// https://leetcode.com/problems/range-sum-query-mutable

// This question can be solved by multiple other ways:
// 1. Using fenwick trees -> Less code / Similar complexity -> Best for interviews.
// 2. Using arrays instead of creating TreeNode by segment tree itself.

class NumArray { // The tree traversals are 1 - Indexed here for easy understanding.
    int totalSize = 0; // Used to provide the total size of array to all functions.
    TreeNode rootNode = null; // Segment tree to be accessed by update and sum functions.
    public class TreeNode { // Segment tree node.
        public int val;
        public TreeNode leftChild;
        public TreeNode rightChild;
    }

    private TreeNode constructSegmentTree(int leftIndex, int rightIndex, int[] nums) {
        final TreeNode node = new TreeNode(); // At every position node should be created.
        if (leftIndex == rightIndex) { // We won't go to the null children.
            node.val = nums[leftIndex - 1];
            return node;
        }
        int mid = (leftIndex + rightIndex) / 2;
        node.leftChild = constructSegmentTree(leftIndex, mid, nums);
        node.rightChild = constructSegmentTree(mid + 1, rightIndex, nums);
        node.val = node.leftChild.val + node.rightChild.val;
        return node;
    }

    public NumArray(int[] nums) {
        rootNode = constructSegmentTree(1, nums.length, nums); // missed saving rootNode
        totalSize = nums.length;
    }

    private void updateTree(TreeNode node, int leftIndex, int rightIndex, int arrIndex, int val) {
        if (leftIndex == rightIndex) {
            node.val = val;
            return;
        }
        int mid = (leftIndex + rightIndex) / 2;
        if (leftIndex <= arrIndex && mid >= arrIndex) updateTree(node.leftChild, leftIndex, mid, arrIndex, val);
        else updateTree(node.rightChild, mid + 1, rightIndex, arrIndex, val);
        node.val = node.leftChild.val + node.rightChild.val; // Update the parent node sum again as their child's have updated.
    }

    public void update(int index, int val) {
        updateTree(rootNode, 1, totalSize, index + 1, val); // Because the calculations are 1 indexed.
    }

    public int calculateSum(TreeNode node, int treeIndexStart, int treeIndexEnd, int toBeCalculatedIndexStart, int toBeCalculatedIndexEnd) {
        if (treeIndexStart == toBeCalculatedIndexStart && treeIndexEnd == toBeCalculatedIndexEnd || treeIndexStart == treeIndexEnd) {
            return node.val;
        }
        int mid = (treeIndexStart + treeIndexEnd) / 2;
        if (mid >= toBeCalculatedIndexEnd) {
            return calculateSum(node.leftChild, treeIndexStart, mid, toBeCalculatedIndexStart, toBeCalculatedIndexEnd);
        }
        if (mid + 1 <= toBeCalculatedIndexStart) { // Forgot + 1 here
            return calculateSum(node.rightChild, mid + 1, treeIndexEnd, toBeCalculatedIndexStart, toBeCalculatedIndexEnd);
        }
        // NOTE: Updating the toBeCalculatedIndexStart & toBeCalculatedIndexEnd as the mid lies between them.
        return calculateSum(node.leftChild, treeIndexStart, mid, toBeCalculatedIndexStart, mid) + calculateSum(node.rightChild, mid + 1, treeIndexEnd, mid + 1, toBeCalculatedIndexEnd);
    }

    public int sumRange(int left, int right) {
        return calculateSum(rootNode, 1, totalSize, left + 1, right + 1); // Because the calculations are 1 - indexed.
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
