//https://leetcode.com/problems/word-search/

class Solution {
    private char[][] b;
    private String s;

    private boolean has(int row, int col, String formedWord, boolean[][] visited) {
        if (!formedWord.equals(s.substring(0, formedWord.length()))) {
            return false;
        }
        if (formedWord.length() == s.length() - 1) {
            return s.equals(formedWord + b[row][col]) ? true : false;
        }

        visited[row][col] = true;

        boolean left = false, right = false, top = false, down = false;

        if (col + 1 < b[0].length && !visited[row][col + 1]) {
            right = has(row, col + 1, formedWord + b[row][col], visited);
        }
        if (row + 1 < b.length && !visited[row + 1][col]) {
            down = has(row + 1, col, formedWord + b[row][col], visited);
        }
        if (col - 1 > -1 && !visited[row][col - 1]) {
            left = has(row, col - 1, formedWord + b[row][col], visited);
        }
        if (row - 1 > -1 && !visited[row - 1][col]) {
            top = has(row - 1, col, formedWord + b[row][col], visited);
        }

        visited[row][col] = false;

        return left || right || top || down;
    }

    public boolean exist(char[][] board, String word) {
        b = board;
        s = word;
        boolean[][] visited = new boolean[board.length][board[0].length]; // change this

        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                if(board[i][j] == word.charAt(0) && has(i, j, "", visited)) return true;

        return false;
    }
}
