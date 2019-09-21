class Solution {
    // You may assume no duplicate exists in the array !!!
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int p = 0; // pivot
        int ans;
        
        // 1. find the pivot via binsearch
        while(low <= high) {
            p = (low + high) / 2;
            if (p > 0 && nums[p-1] < nums[p] || p == 0) {
                if (nums[p] > nums[n-1])
                    low = p + 1;
                else
                    high = p - 1;
            } else { // found
                break;
            }   
        }
        
        // 2. find the target
        low = 0;
        high = p - 1;
        while (low <= high) {
            ans = (low + high) / 2;
            if (nums[ans] < target)
                low = ans + 1;
            else if (nums[ans] > target)
                high = ans - 1;
            else
                return ans;
        }
        
        low = p;
        high = n - 1;
        while (low <= high) {
            ans = (low + high) / 2;
            if (nums[ans] < target)
                low = ans + 1;
            else if (nums[ans] > target)
                high = ans - 1;
            else
                return ans;
        }
        
        return -1;
    }
}