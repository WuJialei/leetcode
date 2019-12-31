/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
 */

// @lc code=start
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
    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return dfs(root);
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        node.val = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        return node.val;
    }

    public boolean dfs(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (node.left == null && node.right == null) {
            return true;
        } else if (node.left == null || node.right == null) {
            int tmp = node.left == null ? node.right.val : node.left.val;
            if (tmp > 1) {
                return false;
            } else {
                return true;
            }
        } else {
            if (Math.abs(node.left.val - node.right.val) > 1) {
                return false;
            } else {
                return dfs(node.left) && dfs(node.right);
            }
        }
        
    }
 
}
// @lc code=end

