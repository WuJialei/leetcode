/*
 * @lc app=leetcode id=671 lang=java
 *
 * [671] Second Minimum Node In a Binary Tree
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
    int val;
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        val = root.val;
        int ans = dfs(root);
        return ans == val ? -1 : ans;
    }

    public int dfs (TreeNode node) {
        if (node == null) {
            return val;
        }
        if (node.val > val) {
            return node.val;
        }
        int left = dfs(node.left); 
        int right = dfs(node.right);
        if (left == val && right == val) {
            return val;
        } else if (left == val || right == val) {
            return left == val ? right : left;
        } else {
            return Math.min(left, right);
        }
    }

}
// @lc code=end

