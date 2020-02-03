/*
 * @lc app=leetcode id=998 lang=java
 *
 * [998] Maximum Binary Tree II
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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        return dfs(root, val);
    }

    public TreeNode dfs(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (node.val < val) {
            TreeNode root = new TreeNode(val);
            root.left = node;
            return root;
        } else {
            node.right = dfs(node.right, val);
            return node;
        }
    }

}
// @lc code=end

