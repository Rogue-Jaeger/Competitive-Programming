// https://leetcode.com/problems/spiral-matrix/

class Solution {

    private List<Integer> spiralTraverser(int[][] matrix, int len, int bre, int level) {
        List<Integer> singleOrder = new ArrayList();


        for (int j = level; j < bre - level; j++) {
            singleOrder.add(matrix[level][j]);
        }

        for (int i = level + 1; i < len - level; i++) {
            singleOrder.add(matrix[i][bre - level - 1]);
        }

        // Imp missed this condition: && (len - level - 1) != level
        for (int j = (bre - level - 2); j >= level && (len - level - 1) != level; j--) {
            singleOrder.add(matrix[len - level - 1][j]);
        }

        // Imp missed this condition && (bre - level - 1) != level
        for (int i = (len - level - 2); i > level && (bre - level - 1) != level; i--) {
            singleOrder.add(matrix[i][level]);
        }

        return singleOrder;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList();
        int spiralLevel = 0, lengthOfMatrix = matrix.length, breadthOfMatrix = matrix[0].length;

        // IMP - Doing + 1 as we want to perform ceil functionality...
        while(spiralLevel < (lengthOfMatrix + 1) / 2 && spiralLevel < (breadthOfMatrix + 1) / 2) {
            order.addAll(spiralTraverser(matrix, lengthOfMatrix, breadthOfMatrix, spiralLevel));
            spiralLevel++;
        }

        return order;
    }
}
