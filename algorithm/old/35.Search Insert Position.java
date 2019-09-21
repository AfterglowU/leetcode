class Solution {
    // You may assume no duplicates in the array !!!
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        
        int low = 0;
        int high = n - 1;
        int p = 0;
        
        
        while (low <= high) {
            p = (low + high) / 2;
            if (nums[p] < target)
                low = p + 1;
            else if (nums[p] > target)
                high = p - 1;
            else
                return p;
        }
        
        // Didn't found target in nums.
        if (nums[p] < target)
            return p + 1;
        else
            return (p == 0) ? 0 : p;
    }
}