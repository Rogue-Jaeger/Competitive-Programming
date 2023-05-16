// https://leetcode.com/problems/reorder-list

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode traverser, endNode, traversersNext;
    boolean done = false;

    public void solve(ListNode node) {
        if (node.next == null) return;

        solve(node.next);

        if (traverser == node || done) {
            done = true;
            return;
        }

        // NOTE: We needed 2 variables instead of 1.
        traversersNext = traverser.next;
        endNode = node.next;
        traverser.next = node.next;
        node.next = node.next.next;
        endNode.next = traversersNext;

        if (traverser.next.next == node) done = true;
        else traverser = traverser.next.next;
    }

    public void reorderList(ListNode head) {
        traverser = head;
        solve(head);
    }

}
