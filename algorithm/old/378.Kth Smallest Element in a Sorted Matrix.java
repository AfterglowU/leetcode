class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1] + 1;
        
        while (low < high) {
            int cnt = 0;
            int mid = low + (high - low) / 2;
            
            // 计算 [matrix[0][0], mid) 区间内的元素数量,
            // 注意我们并没有严格统计出具体元素数量, 而是一旦 cnt >= k 就终止循环.
            // 理论上来说这样可以减少一定循环次数, 提升程序运行速度.
            for (int i = 0, j = n - 1; i < n && j >= 0 && cnt < k; ) {
                if (matrix[i][j] < mid) {
                    cnt += j + 1;
                    j--;
                } else {
                    i++;
                }
            }
            
            if (cnt < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return low;
    }
}