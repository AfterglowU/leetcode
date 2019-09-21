/**
 * 坑: java 不能像 python 那样通过 (k^m - 1) / (k - 1) == n ?  来检验 k 是否符合要求,
 * 因为 java 中 Math.pow 返回的是 double, 而 n 最大可以为 10^18, 从而 k^m - 1 可能超出 double 表示范围(fraction 部分).
 */

class Solution {
    boolean isGood(long n, long base) {
        while (n != 0) {
            if (n % base != 1) return false;
            n /= base;
        }
        return true;
    }
    
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);   // 10^18 < 2^60, so using long is enough
        int max_m = 0;
        for (long tmp = num; tmp != 0; tmp /= 2) {
            max_m++;
        }
        
        for (int m = max_m; m > 2; m--) {
            int k = (int) Math.pow(num, 1.0/(m-1));
            if (isGood(num, (long) k)) return Integer.toString(k);
        }
        
        return Long.toString(num-1);
    }
}