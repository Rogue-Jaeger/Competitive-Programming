//https://leetcode.com/problems/minimum-path-sum/description/

//Suboptimal approach through bruteforce recursion was getting TLE.

class Solution {
    int minSum = Integer.MAX_VALUE;

    private void findMinSum(int[][] grid, int row, int col, int sum) {
        if (grid.length == row + 1 && grid[0].length == col + 1) {
            minSum = Math.min(sum + grid[row][col], minSum);
            return;
        }

        if (grid.length == row || grid[0].length == col) return;

        findMinSum(grid, row + 1, col, sum + grid[row][col]);
        findMinSum(grid, row, col + 1, sum + grid[row][col]);
    }

    public int minPathSum(int[][] grid) {
        findMinSum(grid, 0, 0, 0);
        return minSum;
    }
}

//Optimal approach checking up and left and calculating addition min.

class Solution {
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;

                if (i == 0) grid[i][j] += grid[i][j-1];
                else if (j == 0) grid[i][j] += grid[i-1][j];
                else grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }
}

