/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int height (TreeNode root){
        int h = -1;
        TreeNode tmp = root;
        
        while (tmp != null) {
            h++;
            tmp = tmp.left;
        }
        return h;
    }
    
    public int countNodes(TreeNode root) {
        TreeNode tmp = root;
        int hp = -1;    // height of parent
        int hc = -1;    // height of parent's (right) child tree
        int cnt = 0;
        
        hp = height(root);
        while (tmp != null) {
            if (hp == 0) {
                cnt += 1;
                break;
            }
            
            hc = height(tmp.right);
            if (hp - 1 == hc) {
                cnt += (1 << hp);
                hp = hc;
                tmp = tmp.right;
            } else {
                cnt += (1 << hp-1);
                hp = hp - 1;
                tmp = tmp.left;
            }
        }
        
        return cnt;
    }
}