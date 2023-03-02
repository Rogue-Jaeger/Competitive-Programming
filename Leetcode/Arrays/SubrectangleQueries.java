// https://leetcode.com/problems/subrectangle-queries

// My code submission. 45 MB
class SubrectangleQueries {
    int[][] rect;

    public SubrectangleQueries(int[][] rectangle) {
        rect = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for(int i = row1; i <= row2; i++)
            for(int j = col1; j <= col2; j++)
                rect[i][j] = newValue;

    }

    public int getValue(int row, int col) {
        return rect[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */

// People optimised the memory using IntStream: 43.9 MB
class SubrectangleQueries {
    private final int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        IntStream.range(row1, row2 + 1)
                .forEach(row -> IntStream.range(col1, col2 + 1)
                        .forEach(col -> this.rectangle[row][col] = newValue));
    }

    public int getValue(int row, int col) {
        return this.rectangle[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */
