/**
 * 肯定是动态规划问题, 但是 dp[] 中存的是什么?
 * 1. dp[i]: [0,i] 中 LIS 的长度.
 *    需要遍历 dp[0,i-1] 来计算 dp[i], 时间复杂度 O(n^2)
 * 
 * 2. dp[i]: 所有长度为 i+1 的 Increasing Subsequence 中, 最小的结尾元素.
 *    e.g.
 *        [3,8,4,9,...], 算法运行到 9 时, 有 [3,4], [3,8], [3,9], [4,9],
 *        [8,9] 五个长度为 2 的 IS, 其中 [3,4] 的结尾元素 4 最小, 因此 dp[1] = 4.
 *    补充说明:
 *    1) dp 是有序的, 因此每次对 dp 的更新可以通过二分查找进行.
 *       从而算法的时间复杂度降低为 O(nlogn)
 *    2) 解释: "dp[i] = num"
 *       由于 i 是通过 binsearch 找到的, 因此一定是以下两种情况之一:
 *           a. num <= dp[i]  (根据 dp[i] 的定义, 此时应该用 num 替换 dp[i])
 *           b. dp[i] 尚未填充 (即 i == len, LIS 增加一项)
 *       无论是哪种情况都要执行 dp[i] = num, 因此无需任何判断条件.
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0; // length of LIS
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) i = -(i + 1);
            dp[i] = num; // -> 补充说明 2)
            if (i == len) len++;
        }
        return len;
    }
}