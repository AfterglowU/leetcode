class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0, high = n;
        int h = 0;
        int ans = 0;

        // binsearch h in [0, n]
        while (low <= high) {
            h = (low + high) / 2;
            if (h > 0 && citations[n-h] < h) {
                high = h - 1;
            } else { // h == 0 || citations[n-h] >= h
                ans = (h > ans) ? h : ans;
                low = h + 1;
            }
        }

        return ans;
    }
}