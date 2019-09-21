class Solution {
    public int getMoneyAmount(int n) {
        int[][] cost = new int[n+1][n+1];
        
        for (int end = 1; end < n + 1; end++) {
            for (int start = end; start > 0; start--) {
                int len = end - start + 1;
                switch (len) {
                    case 1:
                        cost[start][end] = 0;
                        break;
                    case 2:
                        cost[start][end] = start;
                        break;
                    case 3:
                        cost[start][end] = start + 1;
                        break;
                    default:
                        int m = start + cost[start+1][end];
                        for (int k = start + 1; k < end; k++) {
                            m = Math.min(m, k + Math.max(cost[start][k-1], cost[k+1][end]));
                        }
                        cost[start][end] = Math.min(m, end + cost[start][end-1]);
                        break;
                }
            }
        }
        
        return cost[1][n];
    }
}