/**
 * 相关问题: 209. Minimum Size Subarray Sum
 * 区别是本题 A 中可能存在负数, 从而无法直接使用 Two-Pointers 方法.
 * 
 * K 可以是负数, 此时返回值应为 1.
 */
class Solution {
    public int shortestSubarray(int[] A, int K) {
        int n = A.length;
        if (n == 0) return -1;
        
        long[] sum = new long[n+1]; // 用 long 防止溢出
        for (int i = 0; i < n; i++)
            sum[i+1] = sum[i] + (long) A[i];
        
        int ans = n+1;  // 初始化为一个不可能的值
        Deque<Integer> monoq = new LinkedList();
        for (int j = 0; j < n + 1; j++) { // [i, j]
            // i 的可能取值为队首元素, 逐个尝试
            while (!monoq.isEmpty() && sum[j] >= sum[monoq.getFirst()] + K)
                ans = Math.min(ans, j - monoq.removeFirst());
            // 确保在队尾添加 j 后队列仍是 monoqueue
            while (!monoq.isEmpty() && sum[j] <= sum[monoq.getLast()])
                monoq.removeLast();
            monoq.addLast(j);
        }
        
        return ans < n + 1 ? ans : -1;
        
    }
}