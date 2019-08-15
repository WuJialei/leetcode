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
    public int rob(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        int ret1 = root.val;
        int ret2 = 0;
        int addLeft = (root.left == null) ? 0: (rob(root.left.left) + rob(root.left.right));
        int addRight = (root.right == null) ? 0: (rob(root.right.left) + rob(root.right.right));
        ret1 = ret1 + addLeft + addRight;
        ret2 += rob(root.left) + rob(root.right);
        return Math.max(ret1, ret2);
    }
}