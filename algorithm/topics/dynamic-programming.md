# Topic: Dynamic Programming

## Best Time to Buy and Sell Stock

- [121. Best Time to Buy and Sell Stock][121]
- [122. Best Time to Buy and Sell Stock II][122]
- [123. Best Time to Buy and Sell Stock III][123]
- [188. Best Time to Buy and Sell Stock IV][188]
- [309. Best Time to Buy and Sell Stock with Cooldown][309]
- [714. Best Time to Buy and Sell Stock with Transaction Fee][714]

## Maximum subarray problem

- [53. Maximum Subarray][53]
- [1186. Maximum Subarray Sum with One Deletion][1186]
- [1191. K-Concatenation Maximum Sum][1191]

## Modulo 10^9+7

~~你TM长点心吧, 是 modulo 不是 module !!!~~

Leetcode 上有好几道题目都因为结果过大, 超出整数表示范围, 因此要求结果 `mod 10^9+7` 后再返回.

其真正含义是: 该程序中的**所有运算(一般而言就是 `+` 和 `*`)都要 `mod 10^9+7`**.

```nohighlight
/* Both A and B are in [0, 1000000007] */

int adder (int A, int B) {
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

- [823. Binary Trees With Factors][823]
- [935. Knight Dialer][935]
- [1191. K-Concatenation Maximum Sum][1191]

[5]: ../solutions/5.longest-palindromic-substring.md
[22]: ../solutions/22.generate-parentheses.md
[32]: ../solutions/32.longest-valid-parentheses.md
[42]: ../solutions/42.trapping-rain-water.md
[53]: ../solutions/53.maximum-subarray.md
[62]: ../solutions/62.unique-paths.md
[72]: ../solutions/72.edit-distance.md
[84]: ../solutions/84.largest-rectangle-in-histogram.md
[87]: ../solutions/87.scramble-string.md
[121]: ../solutions/121.best-time-to-buy-and-sell-stock.md
[122]: ../solutions/122.best-time-to-buy-and-sell-stock-ii.md
[123]: ../solutions/123.best-time-to-buy-and-sell-stock-iii.md
[139]: ../solutions/139.word-break.md
[140]: ../solutions/140.word-break-ii.md
[174]: ../solutions/174.dungeon-game.md
[188]: ../solutions/188.best-time-to-buyand-sell-stock-iv.md
[300]: ../solutions/300.longest-increasing-subsequence.md
[309]: ../solutions/309.best-time-to-buy-and-sell-stock-with-cooldown.md
[354]: ../solutions/354.russian-doll-envelopes.md
[650]: ../solutions/650.2-keys-keyboard.md
[714]: ../solutions/714.best-time-to-buy-and-sell-stock-with-transaction-fee.md
[718]: ../solutions/718.maximum-lengthof-repeated-subarray.md
[787]: ../solutions/787.cheapest-flights-within-k-stops.md
[808]: ../solutions/808.soup-servings.md
[823]: ../solutions/823.binary-trees-with-factors.md
[931]: ../solutions/931.minimum-falling-path-sum.md
[935]: ../solutions/935.knight-dialer.md
[983]: ../solutions/983.minimum-cost-for-tickets.md
[1024]: ../solutions/1024.video-stitching.md
[1130]: ../solutions/1130.minimum-cost-tree-from-leaf-values.md
[1186]: ../solutions/1186.maximum-subarray-sum-with-one-deletion.md
[1191]: ../solutions/1191.k-concatenation-maximum-sum.md
[1218]: ../solutions/1218.longest-arithmetic-subsequence-of-given-difference.md
[1220]: ../solutions/1220.count-vowels-permutation.md
