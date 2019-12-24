/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
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

    List<String> list;

    public List<String> binaryTreePaths(TreeNode root) {
        list = new ArrayList<String>();
        dfs(root, "");
        return list;
    }

    public void dfs (TreeNode node, String str) {
        if (node == null) {
            return;
        }
        String next = "";
        if (str.equals("")) {
            next = str + node.val;
        } else {
            next = str + "->" + node.val;
        }
        if (node.left == null && node.right == null) {
            list.add(next);
            return;
        }
        dfs(node.left, next);
        dfs(node.right, next);
    }

}
// @lc code=end

