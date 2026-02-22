/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private void mapTreeToArr(final String mappedTree, final TreeNode node) {
        if (node == null) mappedTree += "null,";
        mappedTree += node.val + ",";
        mapTreeToArr(mappedTree, node.left);
        mapTreeToArr(mappedTree, node.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        mapTreeToArr("", root);
        System.out.println(mappedArr);
        return "";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return new TreeNode(1);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));