import java.util.*; 

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Hashtable<Integer, Integer> hmap = new Hashtable<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer complement = hmap.get(target - nums[i]);
            if (complement != null) {
                result[0] = complement;
                result[1] = i;
                break;
            }
            hmap.put(nums[i], i);
        }
        return result;
    }
}