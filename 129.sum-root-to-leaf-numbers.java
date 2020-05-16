/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
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

    private int ans;


    public void dfs (TreeNode node, int cnt) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            ans += cnt * 10 + node.val;
            return;
        }
        if (node.left != null) {
            dfs(node.left, cnt * 10 + node.val);
        }
        if (node.right != null) {
            dfs(node.right, cnt * 10 + node.val);
        }
    }

    public int sumNumbers(TreeNode root) {
        ans = 0;
        if (root == null) {
            return ans;
        }
        dfs(root, 0);
        return ans;
    }
}
// @lc code=end

