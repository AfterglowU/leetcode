/**
 * "The array may contain duplicates."
 * 
 * 当存在重复元素时, 二分查找在遇到 nums[0] == nums[mid] == nums[n-1] 时无法判断
 * mid 属于 HIGH ZONE 还是 LOW ZONE. 此时只能使用线性查找.
 * 区间 [0,n) 最终被划分为两部分:
 * HIGH ZONE    [0,low)     所有元素均 >= last
 * LOW  ZONE    [low,n)     所有元素均 <= last
 * 
 * BTW, 在没有遇到 nums[0] == nums[mid] == nums[n-1] 这种情况时,
 * 是可以判断 mid 属于 HIGH ZONE 还是 LOW ZONE 的.
 * 因此还是建议使用二分查找模板, 而不是像一些暴躁老哥根本不判断直接线性查找.
 */
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 0) return -1;
        int low = 0;
        int high = n;
        int last = nums[n-1];
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > last) low = mid + 1;
            else if (nums[mid] < last) high = mid;
            else {
                if (nums[0] != last) {
                    high = mid;
                } else {
                    // resort to linear search
                    for (int i = low; i < high; i++)
                        if (nums[i] < nums[low]) low = i;
                    if (high < n && nums[high] < nums[low]) low = high;
                    break;
                }
            }
        }
        return nums[low];
    }
}