/** 
 * 和 [33] 题不同的是这道题中 nums 内可能存在重复元素,
 * 从而无法在 log(n) 时间内找出 pivot, 所以最坏时间复杂度为 O(n).
 */
class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int p = 0;
        int mid = 0;
        
        // 1. find the pivot
        while (low <= high) {
            p = (low + high) / 2;
            if (p > 0 && nums[p-1] <= nums[p] || p == 0) {
                if (nums[p] > nums[n-1]) // p is in the higher part
                    low = p + 1;
                else if (nums[p] < nums[n-1]) // p is in the lower part
                    high = p - 1;
                else { // The worst case, you can't tell whether p is in the lower part or the higher part.
                    // Brute-Force search
                    for (int i: nums) {
                        if (i == target) {return true;}
                    }
                    return false;
                }
            } else { // found
                break;
            }
        }
        
        // 2. find the target
        low = 0;
        high = p - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] < target)
                low = mid + 1;
            else if (nums[mid] > target)
                high = mid - 1;
            else
                return true;
        }
        
        low = p;
        high = n - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] < target)
                low = mid + 1;
            else if (nums[mid] > target)
                high = mid - 1;
            else
                return true;
        }
        
        return false;
    }
}