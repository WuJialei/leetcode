/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
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

    public class Node {
        TreeNode first;
        TreeNode last;

        public Node (TreeNode x, TreeNode y) {
            first = x;
            last = y;
        }
    }

    public Node dfs(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null || node.right == null) {
            if (node.left == null && node.right == null) {
                return new Node(node, node);
            }
            if (node.left == null) {
                Node r = dfs(node.right);
                node.right = r.first;
                return new Node(node, r.last);
            }
            if (node.right == null) {
                Node l = dfs(node.left);
                node.left = null;
                node.right = l.first;
                return new Node(node, l.last);
            }
        }
        Node l = dfs(node.left);
        node.left = null;
        Node r = dfs(node.right);
        node.right = l.first;
        l.last.right = r.first;
        return new Node(node, r.last);
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Node node = dfs(root);
        root = node.first;
    }
}
// @lc code=end

