/**
 * "You may assume no duplicate exists in the array."
 * 
 * 由于不存在重复元素, 所以可以按照是否 > last 将区间 [0,n) 最终划分为两部分:
 * HIGH ZONE    [0,low)      所有元素均 > last
 * LOW  ZONE    [high,n)     所有元素均 <= last
 * (low == high)
 * 因此直接套用二分查找模板就行.
 */
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int last = nums[n-1];
        int low = 0;
        int high = n;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > last) low = mid + 1;
            else high = mid;
        }
        
        return nums[low];
    }
}