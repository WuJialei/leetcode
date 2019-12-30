/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
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

    int cnt;
    int sum;

    public int pathSum(TreeNode root, int sum) {
        cnt = 0;
        this.sum = sum;
        dfs(root);
        return cnt;
    }

    public void dfs (TreeNode node) {
        if (node == null) {
            return;
        }
        dfs1(node, sum);
        dfs(node.left);
        dfs(node.right);
    }

    public void dfs1 (TreeNode node, int val) {
        if (node == null) {
            return;
        }
        int tmp = val - node.val;
        if (tmp == 0) {
            ++cnt;
        } 
        dfs1(node.left, tmp);
        dfs1(node.right, tmp);     
    }

}
// @lc code=end

