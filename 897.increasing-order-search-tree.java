/*
 * @lc app=leetcode id=897 lang=java
 *
 * [897] Increasing Order Search Tree
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

    List<Integer> tmp;

    public TreeNode increasingBST(TreeNode root) {
        tmp = new ArrayList<Integer>();
        dfs(root);
        if (tmp.size() <= 1) {
            return root;
        }
        TreeNode ans = new TreeNode(tmp.get(0));
        TreeNode ret = ans;
        for (int i = 1; i < tmp.size(); ++i) {
            ans.right = new TreeNode(tmp.get(i));
            ans = ans.right;
        }
        return ret;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        tmp.add(node.val);
        dfs(node.right);
    }

}
// @lc code=end

