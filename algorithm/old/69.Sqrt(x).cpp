// 这道题的本意是在 [1,x] 之间二分查找, 
// 但是更快的做法是使用牛顿法.
class Solution {
public:
    int mySqrt(int x) {
        if (x == 0)
            return 0;
        
        long t = x;
        while (t > x / t) {
            t = (x / t + t) >> 1;
        }
        return (int) t;
    }
};