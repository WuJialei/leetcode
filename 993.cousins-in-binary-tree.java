/*
 * @lc app=leetcode id=993 lang=java
 *
 * [993] Cousins in Binary Tree
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

    Map<Integer, TreeNode> parent;
    Map<Integer, Integer> depth;

    public boolean isCousins(TreeNode root, int x, int y) {

        parent = new HashMap<Integer, TreeNode>();
        depth = new HashMap<Integer, Integer>();
        dfs(new TreeNode(-1), root, 0);
        return depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y);

    }

    public void dfs (TreeNode pre, TreeNode node, int cnt) {
        if (node == null) {
            return;
        }
        depth.put(node.val, cnt);
        parent.put(node.val, pre);
        dfs(node, node.left, cnt + 1);
        dfs(node, node.right, cnt + 1);
    }

}
// @lc code=end

