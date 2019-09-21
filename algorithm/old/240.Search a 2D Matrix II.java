/**
 * Solution1:
 *      时间复杂度: O(m+n)
 * Solution2:
 *      一种比较奇怪的 divide and conquer 思路, 详见 onenote 笔记.
 *      时间复杂度: 介于 O(n) 和 O(n^2) 之间, 但暂时不知道具体是多少.
 */

class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row <= 0) { return false; }
        int col = matrix[0].length;
        int i = row - 1, j = 0;

        while (i >= 0 && j < col) {
            if (matrix[i][j] < target) {
                j++;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                return true;
            }
        }

        return false;
    }
}

class Solution2 {
    boolean search(int[][] matrix, int lr, int lc, int hr, int hc, int target) {
        if (lr == hr && lc == hc) {
            return matrix[lr][lc] == target;
        }
        
        // 将待查范围消减为开区间 ( matrix(lr,lc), matrix(hr,hc) )
        if (matrix[lr][lc] == target || matrix[hr][hc] == target) {
            return true;
        }
        
        int lrt = lr, lct = lc;
        int hrt = hr, hct = hc;
        int mr = 0, mc = 0;
        
        while (hrt - lrt > 1 || hct - lct > 1) {
            mr = (lrt + hrt) / 2;
            mc = (lct + hct) / 2;
            if (matrix[mr][mc] < target) {
                lrt = mr;
                lct = mc;
            } else if (matrix[mr][mc] > target) {
                hrt = mr;
                hct = mc;
            } else {
                return true;
            }
        }
        
        return search(matrix, lr, hct, lrt, hc, target) 
               || search(matrix, hrt, lc, hr, lct, target);
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row <= 0) { return false; }
        int col = matrix[0].length;
        if (col <= 0) { return false; }
        
        return search(matrix, 0, 0, row-1, col-1, target);
    }
}