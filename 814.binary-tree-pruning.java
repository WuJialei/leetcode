/*
 * @lc app=leetcode id=814 lang=java
 *
 * [814] Binary Tree Pruning
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
    public TreeNode pruneTree(TreeNode root) {
        dfs(root);
        return root;
    }

    public boolean dfs(TreeNode node) {
        if (node == null) {
            return false;
        }
        boolean f1 = dfs(node.left);
        boolean f2 = dfs(node.right);
        if (!f1) {
            node.left = null;
        }
        if (!f2) {
            node.right = null;
        }
        return node.val == 1 || f1 || f2;
    }

}
// @lc code=end

