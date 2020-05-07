/*
 * @lc app=leetcode id=1315 lang=java
 *
 * [1315] Sum of Nodes with Even-Valued Grandparent
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

    private int sum;

    public void dfs (TreeNode node) {
        if (node == null) {
            return;
        }
        if ((node.val & 1) == 0) {
            sum += node.left == null ? 0 : (node.left.left == null ? 0 : node.left.left.val);
            sum += node.left == null ? 0 : (node.left.right == null ? 0 : node.left.right.val);
            sum += node.right == null ? 0 : (node.right.left == null ? 0 : node.right.left.val);
            sum += node.right == null ? 0 : (node.right.right == null ? 0 : node.right.right.val);
        }
        dfs(node.left);
        dfs(node.right);
    }

    public int sumEvenGrandparent(TreeNode root) {
        sum = 0;
        dfs(root);
        return sum;
    }
}
// @lc code=end

