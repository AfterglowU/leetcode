/**
 * 注意: 这道题的输入中可能有重复元素.
 * 
 * Solution1: Binsearch
 *      由于最终输出的肯定是连续的 k 个元素, 
 *      因此我们只需要 binsearch 这连续 k 个元素中首个元素即可.
 *      时间复杂度: O(logn)
 * Solution2: Two-Pointers
 *      先通过二分查找找到 x 的区间 (dist = 0).
 *      然后通过首位两个指针扩大这个区间, 直到区间大小为 k.
 *      时间复杂度: O(logn + k)
 */
class Solution1 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // [low, high)
        int n = arr.length;
        int low = 0;
        int high = n - k;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = low; i < low + k; i++) {
            ans.add(arr[i]);
        }
        
        return ans;
    }
}

class Solution2 {
    int binsearch (int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return low;
    }
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // [Left, right)
        int n = arr.length;
        int left = binsearch(arr, x);
        int right = binsearch(arr, x + 1);
        int cnt = right - left;
        int dist = 1;
        
        while (cnt < k) {
            if (left > 0 && arr[left - 1] == x - dist) {
                left--;
                cnt++;
            } else if (right < n && arr[right] == x + dist) {
                right++;
                cnt++;
            } else {
                dist++;
            }
        }
        
        right = (left + k < right) ? left + k : right;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = left; i < right; i++) {
            ans.add(arr[i]);
        }
        
        return ans;
    }
}