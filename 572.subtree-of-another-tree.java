/*
 * @lc app=leetcode id=572 lang=java
 *
 * [572] Subtree of Another Tree
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (dfs(s, t)) {
            return true;
        }
        if (s == null) {
            return false;
        }
        boolean ans = isSubtree(s.left, t) || isSubtree(s.right, t);
        return ans;
    }

    public boolean dfs (TreeNode pat, TreeNode ex) {
        if (pat == null && ex == null) {
            return true;
        } else if (pat == null || ex == null) {
            return false;
        } else {
            if (pat.val != ex.val) {
                return false;
            } else {
                return dfs(pat.left, ex.left) && dfs(pat.right, ex.right);
            }
        }
    }

}
// @lc code=end

