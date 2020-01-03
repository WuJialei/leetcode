/*
 * @lc app=leetcode id=701 lang=java
 *
 * [701] Insert into a Binary Search Tree
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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        insert(root, val);
        return root;
    }

    public void insert(TreeNode node, int val) {
        if (node == null) {
            return;
        }
        if (val < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
                return;
            } else {
                insert(node.left, val);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(val);
                return;
            } else {
                insert(node.right, val);
            }
        }
    }

}
// @lc code=end

