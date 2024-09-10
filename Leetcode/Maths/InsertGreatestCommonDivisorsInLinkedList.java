// https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list

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

    /**
    This is called euclidian algorithm and is based on the fact
    that the GCD divides the difference of 2 numbers.
     */
    private int getGCD(int a, int b) {
        a = Math.abs(a); // Should not be negetive
        b = Math.abs(b); // Should not be negetive
        int temp;
        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head, next = head.next;
        while (next != null) {
            ListNode newNode = new ListNode(getGCD(curr.val, next.val), next);
            curr.next = newNode;
            curr = next;
            next = curr.next;
        }
        return head;
    }
}
