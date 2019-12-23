/*
 * @lc app=leetcode id=783 lang=java
 *
 * [783] Minimum Distance Between BST Nodes
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

    List<Integer> list;

    public int minDiffInBST(TreeNode root) {
        list = new ArrayList<Integer>();
        dfs(root);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); ++i) {
            ans = Math.min(ans, list.get(i) - list.get(i-1));
        }
        return ans;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }

}
// @lc code=end

