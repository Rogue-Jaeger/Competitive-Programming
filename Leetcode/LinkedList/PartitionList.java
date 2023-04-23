// https://leetcode.com/problems/partition-list

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
    public ListNode partition(ListNode head, int x) {

        ListNode highListHead = null, highListCurr = null;
        ListNode sentinelNode = new ListNode(Integer.MIN_VALUE, head);
        ListNode prevNode = sentinelNode;
        
        while (head != null) { // Here head can be used for traversal as sentinel node points to it.
            if (head.val >= x) {
                if (highListHead == null) {
                    highListHead = highListCurr = head;
                } else {
                    highListCurr.next = head;
                    highListCurr = highListCurr.next;
                }

                prevNode.next = head.next;
                head = prevNode.next;
                highListCurr.next = null;
            } else {
                prevNode = head;
                head = head.next;
            }
        }

        prevNode.next = highListHead;

        return sentinelNode.next;
    }
}
