import apple.laf.JRSUIUtils.Tree;

/*
 * @lc app=leetcode id=617 lang=java
 *
 * [617] Merge Two Binary Trees
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root = dfs(t1, t2);
        return root;
    }

    public TreeNode dfs (TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        int sum = 0;
        TreeNode node = new TreeNode(sum);
        if (node1 != null && node2 != null) {
            node.val = node1.val + node2.val;
            node.left = dfs(node1.left, node2.left);
            node.right = dfs(node1.right, node2.right);
            
        } else {
            if (node1 == null) {
                node = node2;
            } else {
                node = node1;
            }
        }
        return node;
        
    }
}
// @lc code=end

