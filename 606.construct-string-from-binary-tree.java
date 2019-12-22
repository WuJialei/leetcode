/*
 * @lc app=leetcode id=606 lang=java
 *
 * [606] Construct String from Binary Tree
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
    public String tree2str(TreeNode t) {
        return dfs(t);
    }

    public String dfs (TreeNode node) {
        if (node == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            return sb.toString();
        }
        sb.append("(");
        sb.append(dfs(node.left));
        sb.append(")");
        if (node.right != null) {
            sb.append("(");
            sb.append(dfs(node.right));
            sb.append(")");
        }
        return sb.toString();
    }
}
// @lc code=end

