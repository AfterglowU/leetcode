// 这题有两种解法
// Solution1:
//      最符合直觉的方法, 也是最快的方法 -> "Two Pointers"
//      使用两个指针, 从头一点点挪到尾部, 每找到一个符合条件的字串就更新一次最小值.
//      时间复杂度: O(n)
// Solution2:
//      开一张大小为 n+1 的表 sum, 表项的含义为 "nums 前 i 项之和":
//          sum[0] = 0;
//          sum[i] = nums[0] + nums[1] + ... + num[i-1];
//      然后遍历 [1,n] 之间的所有值 (子串开头), 通过对 sum 表进行 binsearch 找到字串结尾.
//      说实话没必要这样做 (所以我也没写).
class Solution1 {
public:
    int minSubArrayLen(int s, vector<int>& nums) {
        int n = nums.size();
        int min = n + 1;  // 初始化为一个不可能的值
        int i = 0, j = 0; // [i, j), init to empty
        int sum = 0;
        
        while (j < n) {
            while (sum < s && j < n) {
                sum += nums[j++];
            }

            while (sum >= s) {
                sum -= nums[i++];
            }
            min = (j - i + 1) < min ? (j - i + 1) : min;
        }
        
        return min == (n + 1) ? 0 : min;
    }
};