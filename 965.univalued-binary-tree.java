/*
 * @lc app=leetcode id=965 lang=java
 *
 * [965] Univalued Binary Tree
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
    public boolean isUnivalTree(TreeNode root) {
        if(root == null){
            return false;
        }
        int val = root.val;
        return dfs(root, val);
    }

    public boolean dfs(TreeNode node, int value) {
        if (node == null) {
            return true;
        }
        if (node.val != value) {
            return false;
        } else {
            return dfs(node.left, value) && dfs(node.right, value);
        }

    }

}
// @lc code=end

