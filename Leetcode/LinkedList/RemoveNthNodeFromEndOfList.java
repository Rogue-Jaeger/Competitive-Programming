// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode val = null;
        ListNode iterator = head;
        for(int i = 1; iterator != null; i++) {
            if (i > n) {
                if (val == null) val = head;
                else val = val.next;
            }
            iterator = iterator.next;
        }

        if(val == null) return head.next; // This was a case that I missed... earlier was returning null here.

        val.next = val.next != null ? val.next.next : null;

        return head;       
    }
}
