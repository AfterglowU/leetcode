# Topic: Binary Tree Traversal

## Index

- [Topic: Binary Tree Traversal](#topic-binary-tree-traversal)
  - [Index](#index)
  - [DFS](#dfs)
  - [BFS](#bfs)
  - [通过遍历序列建树](#通过遍历序列建树)

----

## DFS

遍历二叉树. preorder, inorder, postorder 三者均有以下三种遍历方式.

1. Recursive
2. Iterative using Stack
3. Morris Traversal

例题

- [144. Binary Tree Preorder Traversal][144]
- [94. Binary Tree Inorder Traversal][94]
- [145. Binary Tree Postorder Traversal][145]

----

## BFS

最简单的 BFS 是 levelorder traversal:

- [102. Binary Tree Level Order Traversal][102]
- [103. Binary Tree Zigzag Level Order Traversal][103]

而在复杂一点的 BFS 问题中则将二叉树视为无向图, 即一个节点与其父节点之间也有边:

- [863. All Nodes Distance K in Binary Tree][863]

----

## 通过遍历序列建树

前提:

- 树中各节点值互异. 否则解不唯一.

共有三种可行方案. 共同点是必须有 `inorder`, 因为要通过 `inorder` 获取左右子树的信息(大小 or 包含哪些节点). 三种方案为:

1. `preorder` + `inorder`

    - [105. Construct Binary Tree from Preorder and Inorder Traversal][105]

2. `postorder` + `inorder`

    - [106. Construct Binary Tree from Inorder and Postorder Traversal][106]

3. `levelorder` + `inorder`

    leetcode 上没有对应的题目, 这里给出代码及简单说明.

    确定根节点很容易 --- `levelorder` 中的首个节点就是根节点. 问题在于其剩余部分中左子树和右子树是"混杂"在一起的, 不像 `preorder` 和 `postorder` 那样是分开的. 因此要通过 `inorder` 将左右子树从 `levelorder` 中分离, 然后递归地处理左右子树.

    ```python
    from typing import List, Dict

    class Solution:
        def buildTree(self, levelorder: List[int], inorder: List[int]) -> TreeNode:
            inorder_dict, N = {}, len(inorder)
            for i in range(N):
                inorder_dict[inorder[i]] = i
            return self.helper(levelorder, inorder_dict)

        def helper(self, levelorder: List[int], inorder_dict: Dict[int, int]) -> TreeNode:
            if len(levelorder) <= 0: return None
            root_val = levelorder[0]
            k = inorder_dict[root_val]
            root = Node(root_val)
            # Seperate lchild tree and rchild tree from levelorder
            left, right = [], []
            for i in levelorder:
                if inorder_dict[i] < k:
                    left.append(i)
                elif inorder_dict[i] > k:
                    right.append(i)
                else:
                    continue
            root.left = self.helper(left, inorder_dict)
            root.right = self.helper(right, inorder_dict)
            return root
    ```

    复杂度分析:

    - Time:

        时间复杂度的递推式为:

        $$
        \begin{aligned}
            & T(N) = \begin{cases}
                O(1) & : N = 1 \\
                T(L) + T(N-1-L) + O(N) & : N > 1
            \end{cases} \\
            & \text{note:} \\
            & \text{1. L is the size of lchild tree} \\
            & \text{2. O(N) is the time spent on seperating lchild tree and rchild tree from levelorder}
        \end{aligned}
        $$

        这和快速排序的递推式类似 --- 最佳情况是每次左右子树的大小相同, 最坏情况是每次都有一棵子树为空. 因此时间复杂度为:

        $$
        T(N) = \begin{cases}
            \text{best}  & : O(N \log N) \\
            \text{worst} & : O(N^2)
        \end{cases}
        $$

    - Space:

        空间复杂度与时间复杂度的递推式完全相同:

        $$
        \begin{aligned}
            & S(N) = \begin{cases}
                O(1) & : N = 1 \\
                S(L) + S(N-1-L) + O(N) & : N > 1
            \end{cases} \\
        \end{aligned}
        $$

        故最佳与最坏情况也相同. 空间复杂度为:

        $$
        S(N) = \begin{cases}
            \text{best} & : O(N \log N) \\
            \text{worst} & : O(N^2)
        \end{cases}
        $$

        P.S. 若以链表代替数组存储 `levelorder`, 则空间复杂度可以降至 $O(N)$.

[94]: ../solutions/94.binary-tree-inorder-traversal.md
[102]: ../solutions/102.binary-tree-level-order-traversal.md
[103]: ../solutions/103.binary-tree-zigzag-level-order-traversal.md
[105]: ../solutions/105.construct-binary-tree-from-preorder-and-inorder-traversal.md
[106]: ../solutions/106.construct-binary-tree-from-inorder-and-postorder-traversal.md
[144]: ../solutions/144.binary-tree-preorder-traversal.md
[145]: ../solutions/145.binary-tree-postorder-traversal.md
[863]: ../solutions/863.all-nodes-distance-k-in-binary-tree.md
