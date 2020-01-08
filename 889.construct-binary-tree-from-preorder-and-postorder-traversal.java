/*
 * @lc app=leetcode id=889 lang=java
 *
 * [889] Construct Binary Tree from Preorder and Postorder Traversal
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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int len = pre.length - 1;
        return dfs(pre, post, 0, len, 0, len);
    }

    public TreeNode dfs(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd) {
        if (preStart == preEnd) {
            return new TreeNode(pre[preStart]);
        }
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int val = pre[preStart + 1];
        for (int i = postStart; i <= postEnd; ++i) {
            if (val == post[i]) {
                int length = i - postStart;
                root.left = dfs(pre, post, preStart+1, preStart+1+length, postStart, i);
                root.right = dfs(pre, post, preStart+2+length, preEnd, i+1, postEnd-1);
                return root;
            }
        }
        return null;
    }

}
// @lc code=end

