/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isBalanced(root.left) || !isBalanced(root.right)) {
            return false;
        }
        int lHeight = root.left == null ? 0 : root.left.val;
        int rHeight = root.right == null ? 0 : root.right.val;
        root.val = 1 + Math.max(lHeight, rHeight);
        return Math.abs(lHeight - rHeight) <= 1;
    }
}
