/**
 * sum = weight[0] + ... + weight[n-1]
 * 在 [sum / D, sum] 这个范围中寻找答案.
 * 用 O(n) 时间验证是否可行.
 * 时间复杂度: O(nlogn)
 */

class Solution {
    boolean valid(int capacity, int[]weight, int D) {
        int cnt = 1;
        int tmp = capacity;
        for(int cargo : weight) {
            if(cargo > capacity) {
                return false;
            } else if (cargo <= tmp) {
                tmp -= cargo;
            } else {
                cnt++;
                tmp = capacity - cargo;
            }
        }
        
        return cnt <= D;
    }
    
    public int shipWithinDays(int[] weights, int D) {
        int high = 0;
        for (int cargo : weights) {
            high += cargo;
        }
        int low = high / D;
        int mid = 0;
        int capacity = high;
        
        while (low <= high) {
            mid = (low + high) / 2;
            if (valid(mid, weights, D)) {
                capacity = mid < capacity ? mid : capacity;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return capacity;
    }
}