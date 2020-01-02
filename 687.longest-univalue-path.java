/*
 * @lc app=leetcode id=687 lang=java
 *
 * [687] Longest Univalue Path
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

    int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        int tmp = 0;
        if (node.left != null && node.left.val == node.val) {
            tmp += dfs1(node.left, node.val) + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            tmp += dfs1(node.right, node.val) + 1;
        }
        ans = Math.max(ans, tmp);
        dfs(node.left);
        dfs(node.right);
    }

    public int dfs1(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }
        int tmp1 = 0;
        int tmp2 = 0;
        if (node.left != null && node.left.val == val) {
            tmp1 = dfs1(node.left, val) + 1;
        }
        if (node.right != null && node.right.val == val) {
            tmp2 = dfs1(node.right, val) + 1;
        }
        return Math.max(tmp1, tmp2);
    }

}
// @lc code=end

