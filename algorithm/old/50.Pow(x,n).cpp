// 支持指数为负数的快速幂算法.
// Solution1:
//      非递归版本. 甚至比递归版本还要短.
// Solution2:
//      递归版本.

class Solution1 {
public:
    double myPow(double x, int n) {
        int tmp = n;
        double rst = 1;
        for(; tmp != 0; tmp /= 2) {
            if (tmp & 1)
                rst *= x;
            x *= x;
        }
        return (n >= 0) ? rst : 1.0 / rst;
    }
};

class Solution2 {
public:
    double _myPow(double x, int n) {
        if (n == 0)
            return 1;
        else if (n == 1)
            return x;
        else if ((n & 1) == 0)
            return _myPow(x * x, n / 2);
        else
            return _myPow(x * x, n / 2) * x;
    }
    
    double myPow(double x, int n) {
        return (n >= 0) ? _myPow(x, n) : 1.0 / _myPow(x, n);
    }
};