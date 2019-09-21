class Solution {
    // return distance to nearest heater
    int distToNearestHeater(int[] heaters, int target) {
        int m = heaters.length;
        int low = 0;
        int high = m;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (heaters[mid] < target) low = mid + 1;
            else high = mid;
        }
        if (low == 0) {
            return heaters[0] - target;
        } else if (low == m) {
            return target - heaters[m-1];
        } else {
            return Math.min(target - heaters[low-1], heaters[low] - target);
        }
    }
    
    // houses & heaters are in ascending order
    public int findRadius(int[] houses, int[] heaters) {
        int n = houses.length;
        Arrays.sort(heaters);
        int radius = distToNearestHeater(heaters, houses[0]);
        for (int i = 1; i < n; i++) {
            radius = Math.max(radius, distToNearestHeater(heaters, houses[i]));
        }
        return radius;
    }
}