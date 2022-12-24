//https://leetcode.com/problems/zigzag-conversion/

import java.lang.Math;


class Solution {
    private enum Direction {
        UP,
        DOWN;
    }

    private int skipElements(int currRow, int totalRows, Direction dir) {
        return dir == Direction.UP ? Math.max(currRow * 2 - 1, 0) : Math.max((totalRows - currRow - 1) * 2 - 1, 0);
    }

    public String convert(String s, int numRows) {
        String res = "";
        Direction currDirection;
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            int j = i, k;
            while (j < s.length()) {
                res += s.charAt(j);
                k = j;
                if (skipElements(i, numRows, Direction.DOWN) != 0) {
                    j += skipElements(i, numRows, Direction.DOWN) + 1;
                }
                if (skipElements(i, numRows, Direction.UP) != 0) {
                    if (j != k && j < s.length()) res += s.charAt(j);
                    j += skipElements(i, numRows, Direction.UP) + 1;
                }
                if (j == k) {
                    j++;
                }
            }
        }
        return res;
    }
}
