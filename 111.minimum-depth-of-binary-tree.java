/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
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
    public int minDepth(TreeNode root) {
        return dfs(root);
    }

    public int dfs (TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        } else if (node.left != null && node.right != null){
            return Math.min(dfs(node.left), dfs(node.right)) + 1;
        } else {
            int tmp = node.left == null ? dfs(node.right) : dfs(node.left);
            return tmp + 1;
        }
    }

}
// @lc code=end

