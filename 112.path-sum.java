/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
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

    int sum;

    public boolean hasPathSum(TreeNode root, int sum) {
        this.sum = sum;
        return dfs(root, 0);
    }

    public boolean dfs (TreeNode node, int curSum) {
        if (node == null) {
            return false;
        }
        int tmp = curSum + node.val;
        if (node.left == null && node.right == null) {
            return tmp  == sum;
        } else {
            return dfs(node.left, tmp) || dfs(node.right, tmp);
        }
    }

}
// @lc code=end

