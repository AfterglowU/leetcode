# Topic: Stack

## 1. 等价于括号匹配的问题

-> [32. Longest Valid Parentheses][4]

## 2. Greedy by Stack

这些问题的共同点是: 存在某种贪心策略为"找元素 `a` 两侧最近的'括号'"的贪心算法.

1. 什么是元素 `a` 两侧最近的"括号"?

    数组 `A` 中元素 `a` 左右两侧**首个** `>a` 或 `<a` 的元素. 这其实就类似于找距离元素 `a` **最近的括号对**(即该括号对内部没有其他括号对).

2. 找元素 `a` 两侧"括号"的方法:

    两种方法: dp 和 stack. 该 dp 算法的行为和 stack 的行为一致, 在 [84. Largest Rectangle in Histogram][1] 中有详细说明. 以下是一些参考例题:

    1. dp
        - [84. Largest Rectangle in Histogram][1] Solution2: Greedy and DP
        - [1019. Next Greater Node In Linked List][2] Solution1: DP
    2. **stack**
        - [42. Trapping Rain Water][5] Solution3: Greedy by Stack
        - [84. Largest Rectangle in Histogram][1] Solution3: Greedy by Stack
        - [503. Next Greater Element II][6] Solution1: Stack
        - [1019. Next Greater Node In Linked List][2] Solution2: stack

使用该贪心策略的题目有:

- [42. Trapping Rain Water][5]
- [84. Largest Rectangle in Histogram][1]
- [1130. Minimum Cost Tree From Leaf Values][3]

BTW, 因为存在贪心算法, 所以这类题目通常也存在普通 dp 算法(只不过复杂度可能高一点).  
e.g. [1130. Minimum Cost Tree From Leaf Values][3] Solution1: DP

[1]: ../solutions/84.largest-rectanglein-histogram.md
[2]: ../solutions/1019.next-greater-node-in-linked-list.md
[3]: ../solutions/1130.minimum-cost-tree-from-leaf-values.md
[4]: ../solutions/32.longest-valid-parentheses.md
[5]: ../solutions/42.trapping-rain-water.md
[6]: ../solutions/503.next-greater-element-ii.md
[7]: ../solutions/739.daily-temperatures.md
[8]: ../solutions/844.backspace-string-compare.md
