// 标准二分查找模板
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) low = mid + 1;
            else high = mid;
        }
        
        return (low < nums.length && nums[low] == target) ? low : -1;
    }
}