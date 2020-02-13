# Topic: Stack

## 1. 等价于括号匹配的问题

-> [32. Longest Valid Parentheses][32]

## 2. Greedy by Stack

这些问题的共同点是: 存在某种贪心策略为"找元素 `a` 两侧最近的'括号'"的贪心算法.

1. 什么是元素 `a` 两侧最近的"括号"?

    数组 `A` 中元素 `a` 左右两侧**首个** `>a` 或 `<a` 的元素. 这其实就类似于找距离元素 `a` **最近的括号对**(即该括号对内部没有其他括号对).

2. 找元素 `a` 两侧"括号"的方法:

    两种方法: dp 和 stack. 该 dp 算法的行为和 stack 的行为一致, 在 [84. Largest Rectangle in Histogram][84] 中有详细说明. 以下是一些参考例题:

    1. dp
        - [84. Largest Rectangle in Histogram][84] Solution2: Greedy and DP
        - [1019. Next Greater Node In Linked List][1019] Solution1: DP
    2. **stack**
        - [42. Trapping Rain Water][42] Solution3: Greedy by Stack
        - [84. Largest Rectangle in Histogram][84] Solution3: Greedy by Stack
        - [503. Next Greater Element II][503] Solution1: Stack
        - [1019. Next Greater Node In Linked List][1019] Solution2: stack

使用该贪心策略的题目有:

- [42. Trapping Rain Water][42]
- [84. Largest Rectangle in Histogram][84]
- [1130. Minimum Cost Tree From Leaf Values][1130]

BTW, 因为存在贪心算法, 所以这类题目通常也存在普通 dp 算法(只不过复杂度可能高一点).  
e.g. [1130. Minimum Cost Tree From Leaf Values][3] Solution1: DP

[32]: ../solutions/32.longest-valid-parentheses.md
[42]: ../solutions/42.trapping-rain-water.md
[84]: ../solutions/84.largest-rectangle-in-histogram.md
[503]: ../solutions/503.next-greater-element-ii.md
[739]: ../solutions/739.daily-temperatures.md
[844]: ../solutions/844.backspace-string-compare.md
[1019]: ../solutions/1019.next-greater-node-in-linked-list.md
[1130]: ../solutions/1130.minimum-cost-tree-from-leaf-values.md
