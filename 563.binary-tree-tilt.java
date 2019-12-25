/*
 * @lc app=leetcode id=563 lang=java
 *
 * [563] Binary Tree Tilt
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

    public int findTilt(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public int dfs (TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs (node.left);
        int right = dfs(node.right);
        ans += left > right ? left - right : right - left;
        return left + right + node.val;
    }

}
// @lc code=end

