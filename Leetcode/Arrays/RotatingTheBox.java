// https://leetcode.com/problems/rotating-the-box

// Rotating a 2-D array 90 degrees the coordinates i, j in original array now become
// (j, maxI - i)
class Solution {
    private Integer[] getRotatedCoord(int row, int column, int maxRow, int previousLeaves) {
        return new Integer[] {
            column,
            maxRow - row,
            previousLeaves
        };
    }

    public char[][] rotateTheBox(char[][] box) {
        char[][] result = new char[box[0].length][box.length];
        ArrayList<Integer[]> leaves = new ArrayList();
        ArrayList<Integer[]> obstacles = new ArrayList();
        int previousLeaves = 0;

        for (int i = 0; i < box.length; i++) {
            previousLeaves = 0;
            for (int j = 0; j < box[0].length; j++) {
                if (box[i][j] == '*') {
                    if (j != 0 && previousLeaves > 0) leaves.add(getRotatedCoord(i, j - 1, box.length - 1, previousLeaves));
                    obstacles.add(new Integer[] {j, box.length - 1 - i});
                    previousLeaves = 0;
                } else if (box[i][j] == '#') previousLeaves++;
            }
            if (previousLeaves > 0) leaves.add(getRotatedCoord(i, box[0].length - 1, box.length - 1, previousLeaves)); // j - 1 is avoided here...
        }

        for (int i = 0; i < box[0].length; i++) {
            Arrays.fill(result[i], '.');
        }

        while (!leaves.isEmpty()) {
            Integer[] genLeave = leaves.get(0);
            while (genLeave[2] > 0) {
                result[genLeave[0]--][genLeave[1]] = '#';
                genLeave[2]--;
            }
            leaves.remove(0);
        }

        while (!obstacles.isEmpty()) {
            result[obstacles.get(0)[0]][obstacles.get(0)[1]] = '*';
            obstacles.remove(0);
        }

        return result;
    }
}
