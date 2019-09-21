class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int low = 0;
        int high = A.length;
        int mid = 0;
        
        // [0, peek) ascending part
        // [peek, n) descending part
        while (low < high) {
            mid = low + (high - low) / 2;
            if (A[mid] < A[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return low;
    }
}