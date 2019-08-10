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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
        	return false;
        }
        int value = sum - root.val;
        if (root.left == null && root.right == null && value == 0) {
        	return true;
        } else {
        	return hasPathSum(root.left, value) || hasPathSum(root.right, value);
        }

    }
}