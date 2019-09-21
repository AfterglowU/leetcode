/**
 * [width, height] : envelopes
 * 俄罗斯套娃不可以旋转, 即只有 w1 < w2 && h1 < h2 时, 1 才可以被 2 套住.
 * 
 * 相关问题:
 *    300.Longest Increasing Subsequence
 * 
 * 思路:
 * 1. envelopes 按 width 排序, 当 width 相同时, 将 height 大的排在前面.
 *    这样做的原因是:
 *        例如 [3,4] 不能套住 [3,3], 如果不按照 height 反序, 则第二步计算 LIS 时,
 *        [3,3], [3,4] 将非法"贡献"一个 Increasing Subsequence.
 * 2. 对排序后的 envelopes, 求 height 的 Longest Increasing Subsequence.
 * 
 * 时间复杂度: O(nlogn)
 */

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0] == null) return 0;
        
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return b[1] - a[1];
                else return a[0] - b[0];
            }
        });
        
        int[] dp = new int[n];
        int len = 0;
        for (int[] e : envelopes) {
            int i = Arrays.binarySearch(dp, 0, len, e[1]);
            if (i < 0) i = -(i + 1);
            dp[i] = e[1];
            if (i == len) len++;
        }
        
        return len;
    }
}