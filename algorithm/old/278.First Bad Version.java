/**
 * 这道题有两点需要注意:
 *      1. 二分查找的 mid 不要再用下面这个写法了
 *              mid = (low + high) / 2;
 *         以后都写成
 *              mid = low + (high - low) / 2;
 *         这样处理的原因:
 *              1) 前者加法可能溢出, 而后者绝对不会.
 *              2) 当没有溢出的时候, 这两个式子得到的 mid 是一样的.
 *      2. 使用半开半闭区间进行搜索, 本来应该是在 [1,n+1) 之间搜索的,
 *         但是这个题目的前提条件告诉我们一定存在至少一个 bad version,
 *         即第 n 个版本肯定是 bad version,, 因此搜索区间变为 [1,n).
 *         
 */

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int mid = 0;
        int ans = n;
        
        while (low < high) {
            mid = low + (high - low) / 2;   // Rather than "mid = (low + high) / 2", which may cause overflow.
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        // This step is to make the output the same as the expected when n < 1.
        // And I think "return ans;" is ok.
        return low;
    }
}