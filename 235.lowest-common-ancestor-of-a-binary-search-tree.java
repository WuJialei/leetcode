/*
 * @lc app=leetcode id=235 lang=java
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
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

    int minNode, maxNode;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        minNode = Math.min(p.val, q.val);
        maxNode = Math.max(p.val, q.val);
        return dfs(root);
    }

    public TreeNode dfs (TreeNode node) {
        if (node == null) {
            return node;
        }
        if (node.val < minNode) {
            return dfs(node.right);
        } else if (node.val > maxNode) {
            return dfs(node.left);
        } else {
            return node;
        }

    }

}
// @lc code=end

