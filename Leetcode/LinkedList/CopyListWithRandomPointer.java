// https://leetcode.com/problems/copy-list-with-random-pointer

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// There were 2 approaches:
// 1. Create a hashmap and store corresponding node mappings. But will have separate space complexity for hashmap.
// 2. Add a node after each node and repeat this for all nodes and random pointer will be the next to original pointer's
//    random pointer and then detach both linked lists.

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node traverser = head;
        Node newNode;

        // Create nodes.
        while (traverser != null) {
            newNode = new Node(traverser.val);
            newNode.next = traverser.next;
            traverser.next = newNode;
            traverser = newNode.next;
        }

        // Arrange random nodes.
        Node prevNode = head;
        while (prevNode != null) {
            traverser = prevNode.next;
            traverser.random = prevNode.random != null ? prevNode.random.next : null;
            prevNode = traverser.next;
        }

        // Detach linked lists, Major learning was to just do the detachment for all nodes not just for new linked list.
        prevNode = head;
        traverser = prevNode.next;
        head = traverser;
        while (traverser != null) {
            prevNode.next = traverser.next;
            prevNode = traverser;
            traverser = prevNode.next;
        }

        return head;
    }
}
