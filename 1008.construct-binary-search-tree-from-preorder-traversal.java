/*
 * @lc app=leetcode id=1008 lang=java
 *
 * [1008] Construct Binary Search Tree from Preorder Traversal
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

    int[] preorder;
    int index;
    int len;

    public TreeNode bstFromPreorder(int[] preorder) {
        index = 0;
        this.preorder = preorder;
        len = preorder.length - 1;
        return dfs(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode dfs(int a, int b) {
        if (index > len) {
            return null;
        }
        if (preorder[index] < a || preorder[index] > b) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[index]);
        ++index;
        node.left = dfs(a, preorder[index-1]);
        node.right = dfs(preorder[index-1], b);
        return node;
    }

}
// @lc code=end

