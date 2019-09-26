# Topic: Dynamic Programming

## Best Time to Buy and Sell Stock

- [121. Best Time to Buy and Sell Stock][8]
- [122. Best Time to Buy and Sell Stock II][9]
- [123. Best Time to Buy and Sell Stock III][10]
- [188. Best Time to Buy and Sell Stock IV][11]
- [309. Best Time to Buy and Sell Stock with Cooldown][12]
- [714. Best Time to Buy and Sell Stock with Transaction Fee][13]

## Maximum subarray problem

- [53. Maximum Subarray][5]
- [1186. Maximum Subarray Sum with One Deletion][28]

## Modulo 10^9+7

~~你TM长点心吧, 是 modulo 不是 module !!!~~

Leetcode 上有好几道题目都因为结果过大, 超出整数表示范围, 因此要求结果 `mod 10^9+7` 后再返回.

其真正含义是: 该程序中的**所有运算(一般而言就是 `+` 和 `*`, 因为只有这两个会导致上溢出)都要 `mod 10^9+7`**.

```nohighlight
/* Both A and B are in [0, 1000000007] */

int Adder (int A, int B) {
    return (A + B) % 100000007;
}

int multiplier () {
    long tmp = (long) A * (long) B;
    return (int) (tmp % 100000007);
}
```

加法的中间结果可以就用 int 存储, 因为 `1000000007 + 1000000007 < 2147483647` 不会导致上溢出. 但是乘法的中间结果必须用 long 存储, 因为两个 32-bits signed int 的乘积最大可占用 62-bits (不含符号位), 故必须用 long.

当然用 python 就无需纠结中间结果用什么类型存了, 反正 python 的 int 不限长, 记得每次计算后 `% 1000000007` 就行.

BTW, 已经对这个数字有 PTSD 了.

- [823. Binary Trees With Factors][22]
- [935. Knight Dialer][24]

[1]: ../solutions/5.longest-palindromic-substring.md
[2]: ../solutions/22.generate-parentheses.md
[3]: ../solutions/32.longest-valid-parentheses.md
[4]: ../solutions/42.trapping-rain-water.md
[5]: ../solutions/53.maximum-subarray.md
[6]: ../solutions/62.unique-paths.md
[7]: ../solutions/72.edit-distance.md
[8]: ../solutions/121.best-time-to-buy-and-sell-stock.md
[9]: ../solutions/122.best-time-to-buy-and-sell-stock-ii.md
[10]: ../solutions/123.best-time-to-buy-and-sell-stock-iii.md
[11]: ../solutions/188.best-time-to-buyand-sell-stock-iv.md
[12]: ../solutions/309.best-time-to-buy-and-sell-stock-with-cooldown.md
[13]: ../solutions/714.best-time-to-buy-and-sell-stock-with-transaction-fee.md
[14]: ../solutions/139.word-break.md
[15]: ../solutions/174.dungeon-game.md
[16]: ../solutions/300.longest-increasing-subsequence.md
[17]: ../solutions/354.russian-doll-envelopes.md
[18]: ../solutions/650.2-keys-keyboard.md
[19]: ../solutions/718.maximum-lengthof-repeated-subarray.md
[20]: ../solutions/787.cheapest-flights-within-k-stops.md
[21]: ../solutions/808.soup-servings.md
[22]: ../solutions/823.binary-trees-with-factors.md
[23]: ../solutions/931.minimum-falling-path-sum.md
[24]: ../solutions/935.knight-dialer.md
[25]: ../solutions/983.minimum-cost-for-tickets.md
[26]: ../solutions/84.largest-rectanglein-histogram.md
[27]: ../solutions/1024.video-stitching.md
[28]: ../solutions/1186.maximum-subarray-sum-with-one-deletion.md
