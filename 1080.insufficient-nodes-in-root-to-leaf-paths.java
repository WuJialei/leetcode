/*
 * @lc app=leetcode id=1080 lang=java
 *
 * [1080] Insufficient Nodes in Root to Leaf Paths
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

    private int limit;

    public boolean dfs(TreeNode node, int cnt) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return node.val + cnt >= limit;
        }
        boolean left = dfs(node.left, cnt + node.val);
        boolean right = dfs(node.right, cnt + node.val);
        if (!left || !right) {
            if (!left && !right) {
                node.left = null;
                node.right = null;
                return false;
            }
            if (!left) {
                node.left = null;
            } else {
                node.right = null;
            }
        }
        return true;
    }

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        this.limit = limit;
        TreeNode node = root;
        boolean ans = dfs(node, 0);
        if (!ans) {
            return null;
        }
        return node;
    }
}
// @lc code=end

