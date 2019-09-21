class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row <= 0) {
            return false;
        }
        int col = matrix[0].length;
        int low = 0;
        int high = row * col - 1;
        int mid = 0;
        int tmp = 0;
        
        while (low <= high) {
            mid = (low + high) / 2;
            tmp = matrix[mid / col][mid % col];
            if (tmp < target) {
                low = mid + 1;
            } else if (tmp > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        
        return false;
    }
}