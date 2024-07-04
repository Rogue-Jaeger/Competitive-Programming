// https://leetcode.com/problems/number-of-islands/description/

class Solution {
    int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}}; // See how to declare 2D array.

    private void traverse(char[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || col < 0 // Order of this check matters as I put in grid[row][col] check here first.
            || row == grid.length || col == grid[0].length
            || grid[row][col] == '0' || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        for (int i = 0; i < directions.length; i++) {
            traverse(grid, visited, row + directions[i][0], col + directions[i][1]);
        }
    }

    public int numIslands(char[][] grid) {
        final boolean[][] visited = new boolean[grid.length][grid[0].length];
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    traverse(grid, visited, i, j);
                    result++;
                }
            }
        }
        return result;
    }
}
