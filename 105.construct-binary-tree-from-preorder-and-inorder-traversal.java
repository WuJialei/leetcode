/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private int[] pre;
    private int[] in;

    public TreeNode dfs (int a, int b, int c, int d) {
        if (a > b || c > d) {
            return null;
        }
        if (a == b) {
            return new TreeNode(pre[a]);
        }
        int val = pre[a];        
        int index = -1;
        for(int i = c; i <= d; ++i) {
            if (val == in[i]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return null;
        }
        TreeNode node = new TreeNode(val);
        node.left = dfs(a+1, a+index-c, c, index-1);
        node.right = dfs(a+index-c+1, b, index+1, d);
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        pre = preorder;
        in = inorder;
        return dfs(0, pre.length - 1, 0, in.length - 1);
    }
}
// @lc code=end

