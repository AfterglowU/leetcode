/**
 * Solution1:
 *      较优解法.使用了 "找出首个 >= target 的元素的位置" 的 binsearch,
 *      并且 binsearch 既可以用来找左边界,也可以用来找右边界.
 * Solution2:
 *      普通解法, 通过两个不同的 binsearch 分别找出左右边界.
 */
class Solution1 {
    // Return the index of the first element that >= target.
    int binsearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        int mid = 0;
        
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return low;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int start = binsearch(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1,-1};
        }
        return new int[]{start, binsearch(nums, target + 1) - 1};
    }
}

class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int lowerBound = 0;
        int upperBound = 0;
        int[] ans = new int[2];
        
        // lower bound
        while (low <= high) {
            lowerBound = (low + high) / 2;
            if (nums[lowerBound] < target)
                low = lowerBound + 1;
            else if (nums[lowerBound] > target)
                high = lowerBound - 1;
            else if (lowerBound > 0 && nums[lowerBound-1] == nums[lowerBound])
                high = lowerBound - 1;
            else
                break;
        }
        
        if (n == 0 || nums[lowerBound] != target) {
            ans[0] = -1;
            ans[1] = -1; 
            return ans;
        }
        
        // upper bound
        low = 0;
        high = n - 1;
        while (low <= high) {
            upperBound = (low + high) / 2;
            if (nums[upperBound] < target)
                low = upperBound + 1;
            else if (nums[upperBound] > target)
                high = upperBound - 1;
            else if (upperBound < n - 1 && nums[upperBound] == nums[upperBound + 1])
                low = upperBound + 1;
            else
                break;
        }
        
        ans[0] = lowerBound;
        ans[1] = upperBound; 
        return ans;
    }
}