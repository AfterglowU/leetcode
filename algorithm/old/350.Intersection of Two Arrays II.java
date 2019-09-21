/**
 * Solution1 和 Solution2 的操作类似, 流程如下:
 * 1. 调整输入, 使得
 *      a[]; a.length = m
 *      b[]; b.length = n
 *      (m <= n)
 * 2. 对两个数组排序
 * 3. Solution1: Two-Pointers 解法
 *    Solution2: Binsearch 解法
 * 
 * Solution3 针对 nums2 过大无法存入内存(从而无法排序)的情况, 因而考虑使用 hashmap.
 * 时间复杂度 O(m+n)
 * 空间复杂度 O(m)
 */

class Solution1 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] a = (nums1.length < nums2.length) ? nums1 : nums2;
        int[] b = (nums1.length < nums2.length) ? nums2 : nums1;
        int m = (nums1.length < nums2.length) ? nums1.length : nums2.length;
        int n = (nums1.length < nums2.length) ? nums2.length : nums1.length;
        ArrayList<Integer> ansl = new ArrayList<Integer>();
        
        Arrays.sort(a);
        Arrays.sort(b);
        
        for (int i = 0, j = 0 ; i < m && j < n;) {
            if (a[i] == b[j]) {
                ansl.add(a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        
        int[] ans = new int[ansl.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ansl.get(i);
        }
        
        return ans;
    }
}

class Solution2 {
    int binsearch(int nums[], int target) {
        int low = 0, high = nums.length;
        
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
    
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] a = (nums1.length < nums2.length) ? nums1 : nums2;
        int[] b = (nums1.length < nums2.length) ? nums2 : nums1;
        int m = (nums1.length < nums2.length) ? nums1.length : nums2.length;
        int n = (nums1.length < nums2.length) ? nums2.length : nums1.length;
        ArrayList<Integer> ansl = new ArrayList<Integer>();
        
        Arrays.sort(a);
        Arrays.sort(b);
        
        for (int i = 0 ; i < m;) {
            int cnta = binsearch(a,a[i]+1) - binsearch(a,a[i]);
            int cntb = binsearch(b,a[i]+1) - binsearch(b,a[i]);
            
            if (cntb > 0) {
                int cnt = (cnta < cntb) ? cnta : cntb;
                for (int j = 0; j < cnt; j++) {
                    ansl.add(a[i]);
                }
            }
            
            i += cnta;
        }
        
        int[] ans = new int[ansl.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ansl.get(i);
        }
        
        return ans;
    }
}

/**
 * What if elements of nums2 are stored on disk,
 * and the memory is limited such that you cannot load all elements into the memory at once? */ 
class Solution3 {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> ansl = new ArrayList<Integer>();
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        
        // init hashmap with nums1
        for (int i : nums1){
            Integer cnt =  hmap.get(i);
            if (cnt != null) {
                hmap.put(i, cnt+1);
            } else {
                hmap.put(i, 1);
            }
        }
        
        for (int i : nums2) {
            Integer cnt =  hmap.get(i);
            if (cnt != null && cnt > 0) {
                ansl.add(i);
                hmap.put(i, cnt-1);
            }
        }
        
        int[] ans = new int[ansl.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ansl.get(i);
        }
        return ans;
    }
}