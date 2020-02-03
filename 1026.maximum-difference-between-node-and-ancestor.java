/*
 * @lc app=leetcode id=1026 lang=java
 *
 * [1026] Maximum Difference Between Node and Ancestor
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

    int ans;

    public class MinMaxNode {
        int min;
        int max;
        MinMaxNode(int x, int y) { 
            min = x; 
            max = y;
        }
    }

    public int maxAncestorDiff(TreeNode root) {
        ans = Integer.MIN_VALUE;
        dfs(root);
        return ans;
    }

    public MinMaxNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }
        if(node.left == null && node.right == null) {
            return new MinMaxNode(node.val, node.val);
        } else {
            int min = node.val;
            int max = node.val;
            MinMaxNode left = dfs(node.left);
            MinMaxNode right = dfs(node.right);
            if (left != null) {
                min = Math.min(min, left.min);
                max = Math.max(max, left.max);
                ans = Math.max(Math.abs(node.val - left.min), ans);
                ans = Math.max(Math.abs(node.val - left.max), ans);
            }
            if (right != null) {
                min = Math.min(min, right.min);
                max = Math.max(max, right.max);
                ans = Math.max(Math.abs(node.val - right.min), ans);
                ans = Math.max(Math.abs(node.val - right.max), ans);
            }
            min = Math.min(node.val, min);
            max = Math.max(node.val, max);
            return new MinMaxNode(min, max);
        }
    }

}
// @lc code=end

