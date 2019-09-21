/**
 * 最近更新: 2019.04.18
 * 目前的版本是 binsearch + dfs, dfs 用的是循环而不是递归, 所以写的比较长且丑.
 */

class Solution {
    boolean hasPath(int t, int[][] grid) {
        int n = grid.length;
        if (grid[0][0] > t || grid[n-1][n-1] > t) {
            return false;
        }
        
        // direction and c(cx,cy)
        //   3
        // 2 c 0
        //   1
        int d = 0;
        int cx = 0, cy = 0;
        boolean[][] visited = new boolean[n][n];
        boolean step = false;
        Stack<Integer> sd = new Stack<Integer>(); // stack of direction
        
        sd.push(-1); // dummy
        visited[0][0] = true;
        while (!sd.empty() && !visited[n-1][n-1]) {
            while (!step) {
                switch(d) {
                    case 0:
                        if (cy < n - 1 && grid[cx][cy+1] <= t && !visited[cx][cy+1]) {
                            visited[cx][++cy] = true;
                            sd.push(d);
                            step = true;
                        } else {
                            d++;
                        }
                        break;
                    case 1:
                        if (cx < n - 1 && grid[cx+1][cy] <= t && !visited[cx+1][cy]) {
                            visited[++cx][cy] = true;
                            sd.push(d);
                            d = 0;
                            step = true;
                        } else {
                            d++;
                        }
                        break;
                    case 2:
                        if (cy > 0 && grid[cx][cy-1] <= t && !visited[cx][cy-1]) {
                            visited[cx][--cy] = true;
                            sd.push(d);
                            d = 0;
                            step = true;
                        } else {
                            d++;
                        }
                        break;
                    case 3:
                        if (cx > 0 && grid[cx-1][cy] <= t && !visited[cx-1][cy]) {
                            visited[--cx][cy] = true;
                            sd.push(d);
                            d = 0;
                            step = true;
                        } else {
                            d++;
                        }
                        break;
                    case 4: // No where to go QuQ
                        d = sd.pop();
                        switch(d) {
                            case 0:
                                cy--;
                                break;
                            case 1:
                                cx--;
                                break;
                            case 2:
                                cy++;
                                break;
                            case 3:
                                cx++;
                                break;
                            default:
                                break;
                        }
                        d++;
                        step = true;
                        break;
                    default:
                        // Never reach here
                        break;
                }
            }
            
            step = false;
        }

        if (visited[n-1][n-1]) {
            return true;
        } else {
            return false;
        }
    }
    
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int low = 2 * n - 2, high = n*n-1;
        int mid = 0;
        int ans = high;
        
        while (low <= high) {
            mid = (low + high) / 2;
            if (hasPath(mid, grid)) {
                ans = (mid < ans) ? mid : ans;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return ans;
    }
}