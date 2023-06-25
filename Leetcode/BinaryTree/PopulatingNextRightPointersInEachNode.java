// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

// Note can we check if this can be done without using extra space?

class Solution {
    Node[] nodeAtLevel =  new Node[13];

    public void arrangeNextPointer(Node node, int level) {
        if (node == null) return;

        if (Objects.nonNull(nodeAtLevel[level])) {
            nodeAtLevel[level].next = node;
        }
        nodeAtLevel[level] = node;

        arrangeNextPointer(node.left, level + 1);
        arrangeNextPointer(node.right, level + 1);
    }

    public Node connect(Node root) {
        arrangeNextPointer(root, 0);
        return root;
    }
}
