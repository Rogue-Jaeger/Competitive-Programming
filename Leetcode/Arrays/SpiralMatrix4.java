// https://leetcode.com/problems/spiral-matrix-iv

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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result = new int[m][n];
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

        for (int i = 0; i < m; i++) {
            Arrays.fill(result[i], -1);
        }

        int row = 0, col = 0, directionIndex = 0, nextRow = 0, nextCol = 0;
        while (head != null) {
            result[row][col] = head.val;
            nextRow = row + directions[directionIndex][0];
            nextCol = col + directions[directionIndex][1];
            if (nextRow < 0 || nextRow == m || nextCol < 0 || nextCol == n || result[nextRow][nextCol] != -1) directionIndex = (++directionIndex) % 4;
            row += directions[directionIndex][0];
            col += directions[directionIndex][1];
            head = head.next;
        }

        return result;
    }
}
