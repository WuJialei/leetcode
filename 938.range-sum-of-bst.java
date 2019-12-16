/*
 * @lc app=leetcode id=938 lang=java
 *
 * [938] Range Sum of BST
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

    public int rangeSumBST(TreeNode root, int L, int R) {
        ans = 0;
        dfs(root, L, R);
        return ans;
    }

    public void dfs (TreeNode node, int l, int r) {
        if (node == null) {
            return;
        }
        
        if (node.val >= l && node.val <= r) {
            ans += node.val;
        }
        // 要不要走左子树
        if (node.val > l) {
            dfs (node.left, l, r);
        }
        // 要不要走右子树
        if (node.val < r) {
            dfs (node.right, l, r);
        }
    }

}
// @lc code=end

