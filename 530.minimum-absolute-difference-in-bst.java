/*
 * @lc app=leetcode id=530 lang=java
 *
 * [530] Minimum Absolute Difference in BST
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
    List<Integer> list;

    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        list = new ArrayList<Integer>();
        dfs(root);
        for (int i = 1; i < list.size(); ++i) {
            ans = Math.min(ans, list.get(i) - list.get(i - 1));
        }
        return ans;
    }

    public void dfs (TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }

}
// @lc code=end

