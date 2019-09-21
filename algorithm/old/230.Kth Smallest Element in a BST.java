/** 
 * Solution1:
 *      Solution2 的非递归版本.
 * Solution2:
 *      中序遍历, 利用 BST 的性质
 *          1. Max(Left) < root < Min(Right)
 *          2. 没有重复元素
 *      寻找第 k 个元素.
 *      时间复杂度: O(k + logn)
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution1 {
    // A non-recursive version.
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {return -1;}
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        boolean lChildDone = false;
        TreeNode tos = null;
        while (!s.empty()) {
            while (s.peek().left != null && !lChildDone) {
                s.push(s.peek().left);
            }
            
            tos = s.pop();
            if (--k == 0) {
                return tos.val;
            }
            
            if (tos.right != null) {
                s.push(tos.right);
                lChildDone = false;
            } else {
                lChildDone = true;
            }
        }
        
        return -1;
    }
}

class Solution2 {
    void _traverse(TreeNode root, int[]t) {
        if (root.left != null) {
            _traverse(root.left, t);
        }
        
        t[0] -= 1;
        if (t[0] == 0) {
            t[1] = root.val;
            return;
        }
        
        if (root.right != null) {
            _traverse(root.right, t);
        }
    }
    
    public int kthSmallest(TreeNode root, int k) {
        int[] t = new int[2];
        t[0] = k;
        
        if (root != null) {
            _traverse(root, t);
            return t[1];
        } else {
            return -1;
        }
    }
}