// https://leetcode.com/problems/clone-graph

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Node, Node> nodeMapper = new HashMap();
    private Node headNode = null;

    private void createNodes(Node node) {
        Node newNode = new Node(node.val);
        nodeMapper.put(node, newNode);

        if (headNode == null) headNode = newNode;

        for (Node neighbor: node.neighbors) {
            // if (nodeMapper.get(neighbor) == null) {
            if (!nodeMapper.containsKey(neighbor)) { // Write this instead of above line.
                createNodes(neighbor);
            }
            newNode.neighbors.add(nodeMapper.get(neighbor));
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        createNodes(node);
        return headNode;
    }
}

// A more optimised approach with same idea, At every step return the created node so it'll take care of returning head
// node and if condition at the start of every node ensures head== null condition and everything is nicely
// wrapped in a single function.
class Solution {
    // need a mapping relationship
    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        if (map.containsKey(node)) {
            return map.get(node);
        }
        // copy val
        Node copy = new Node(node.val);
        map.put(node, copy);
        // copy neighbors
        for (Node n : node.neighbors) {
            copy.neighbors.add(cloneGraph(n));
        }
        return copy;
    }
}
