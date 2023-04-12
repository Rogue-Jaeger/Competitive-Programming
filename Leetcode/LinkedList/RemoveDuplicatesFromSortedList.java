// https://leetcode.com/problems/remove-duplicates-from-sorted-list

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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        int prev = head.val;
        ListNode node = head;

        while (node.next != null) { // can be done by node == null and above if condition can be removed but this is also okay.
            if (node.next.val == node.val) node.next = node.next.next;
            else node = node.next;
        }

        return head;
    }
}
