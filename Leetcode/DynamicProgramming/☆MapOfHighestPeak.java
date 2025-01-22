// https://leetcode.com/problems/map-of-highest-peak

// By converting the `Integer[]` to `int[]` below saved 14ms of time.

class Solution {
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    void getNextValidIndices(int[][] isWater, boolean[][] visited, LinkedList<Integer[]> queue, int row, int col, int val) {
        int nextRow, nextCol;
        for (int i = 0; i < directions.length; i++) {
            nextRow = row + directions[i][0]; nextCol = col + directions[i][1]; // Only at the time of declarations we can do with commas but not here!
            if (!(nextRow < 0 || nextRow == isWater.length || nextCol < 0 || nextCol == isWater[0].length || visited[nextRow][nextCol])) {
                queue.add(new Integer[] {nextRow, nextCol, val + 1});
                visited[nextRow][nextCol] = true;
            }
        }
    }

    public int[][] highestPeak(int[][] isWater) {
        LinkedList<Integer[]> queue = new LinkedList();
        boolean[][] visited = new boolean[isWater.length][isWater[0].length];

        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                if (isWater[i][j] == 1) {
                    queue.add(new Integer[] {i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        Integer[] cell;
        while (!queue.isEmpty()) {
            cell = queue.poll();
            getNextValidIndices(isWater, visited, queue, cell[0], cell[1], cell[2]);
            isWater[cell[0]][cell[1]] = cell[2];
        }

        return isWater;
    }
}
