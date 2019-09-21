'''
n(10) = 1111...1(k), 共 m 个 1
在 [2, n-1] 之间盲目搜索 k 显然不行, 因为 3 <= n <= 10^18.
所以只能转为在 [2, 1 + logn] 之间从高到低盲目搜索 m.
这其实就是二分思想, 将复杂度从 O(n) 降低到了 O(logn).

用 python 就不需要考虑:
    1. n 需要用多少位存 (其他语言要用 long)
    2. 超出 double 表示范围导致精度损失
'''

class Solution:
    def smallestGoodBase(self, n: str) -> str:
        n = int(n)
        max_m = int(math.log(n,2)) + 1
        for m in range(max_m, 2,-1):
            k = int(n**(m-1)**-1)
            if (k**m - 1) // (k - 1) == n:  
                return str(k)
        return str(n-1)