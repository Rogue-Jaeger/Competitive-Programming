class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int start = 0, end = matrix.length - 1, mid = (start + end) / 2;
        
        
        while (end - start > 1) {
            if(target == matrix[mid][0]) return true;
            
            if(target > matrix[mid][0]) {
                start = mid; // Don't do +1 here if you never want start == end
            } else {
                end = mid; // Don't do -1 here if you never want start == end
            }
            
            mid = (start + end) / 2;
        }
        
        int rowToSearch = matrix[end][0] <= target ? end : start;
        
        start = 0;
        end = matrix[rowToSearch].length - 1;
        mid = (start + end) / 2;
        
        while (end - start > 1) {
            if(target == matrix[rowToSearch][mid]) return true;
            
            if(target > matrix[rowToSearch][mid]) {
                start = mid;
            } else {
                end = mid;
            }
            
            mid = (start + end) / 2;
        }
        
        
        return matrix[rowToSearch][start] == target || matrix[rowToSearch][end] == target;
    }
}
