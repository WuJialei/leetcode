/*
 * @lc app=leetcode id=700 lang=java
 *
 * [700] Search in a Binary Search Tree
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
    public TreeNode searchBST(TreeNode root, int val) {
        // TreeNode ret = dfs (root, val);
        TreeNode ret = null;
        if (root == null) {
            return null;
        }
        while (root != null) {
            if (root.val == val) {
                ret = root;
                break;
            }else if (val < root.val) {
                root = root.left;
            } else if (val > root.val) {
                root = root.right;
            }            
        }
        return ret;
    }

    public TreeNode dfs (TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        if (node.val == val) {
            return node;
        } else if (val < node.val) {
            return dfs(node.left, val);
        } else {
            return dfs(node.right, val);
        }
    }

}
// @lc code=end

