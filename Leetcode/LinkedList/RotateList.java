// https://leetcode.com/problems/rotate-list

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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;

        // Initializing variables.
        int length = 1;
        ListNode lastElement = head, pivot = head;

        // Checking the length of linkedList while fetching the last element in the process.
        while (lastElement.next != null) {
            length++;
            lastElement = lastElement.next;
        }

        // Don't have to traverse all the way... Just traverse how many times pivot is to be shifted.
        for (int i = 0; i < (length - (k % length) - 1); i++) {
            pivot = pivot.next;
        }

        // Doing pointer operations.
        lastElement.next = head;
        head = pivot.next;
        pivot.next = null;

        return head;
    }
}
