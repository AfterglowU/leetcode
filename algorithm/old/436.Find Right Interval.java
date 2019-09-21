/**
 * 思路:
 * 1. 题目中说 "You may assume none of these intervals have the same start point."
 *    因此可以使用每个区间的左边界(start)作为该区间的唯一标识.
 * 2. 因为
 */
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] ans = new int[n];
        int[] start = new int[n];
        HashMap<Integer, Integer> hmap = new HashMap<> ();
        
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            hmap.put(intervals[i][0], i);
        }
        Arrays.sort(start);
        
        for(int i = 0; i < n; i++) {
            int low = 0;
            int high = n;
            int target = intervals[i][1];
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (start[mid] < target) low = mid + 1;
                else high = mid;
            }
            ans[i] = (low == n) ? -1 : hmap.get(start[low]);
        }
        return ans;
    }
}