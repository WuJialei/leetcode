/*
 * @lc app=leetcode id=404 lang=java
 *
 * [404] Sum of Left Leaves
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

    public int sumOfLeftLeaves(TreeNode root) {
        ans = 0;
        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode node, int flag) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (flag == 1) {
                ans += node.val;
            }
            return;
        }
        dfs(node.left, 1);
        dfs(node.right, 2);
    }

}
// @lc code=end

