// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii

// Using just a single while loop to solve was asking for too many variables 
// ie. traverser, pointerToStartOfThePattern etc  

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
        ListNode dummyHead = new ListNode(101, head); // This is called a sentinel node.
        ListNode prevNode = dummyHead;

        while (head != null) { // imp head can be used here to traverse as we're using dummyHead as Head
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }

                prevNode.next = head.next;
            } else prevNode = prevNode.next;

            head = head.next;
        }

        return dummyHead.next;

    }
}
