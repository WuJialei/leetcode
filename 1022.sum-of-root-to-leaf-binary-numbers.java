/*
 * @lc app=leetcode id=1022 lang=java
 *
 * [1022] Sum of Root To Leaf Binary Numbers
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

    public int sumRootToLeaf(TreeNode root) {
        sum = 0;
        dfs(root, 0);
        return sum;
    }

    public void dfs (TreeNode node, int cntSum) {
        if (node == null) {
            return;
        } else if (node.left == null && node.right == null) {
            sum += cntSum * 2 + node.val;
            return;
        } else {
            dfs(node.left, cntSum * 2 + node.val);
            dfs(node.right, cntSum * 2 + node.val);
        }
    }

}
// @lc code=end

