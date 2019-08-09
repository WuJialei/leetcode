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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    	if (t1 == null && t2 == null) {
    		return null;
    	}
        TreeNode root = null;
        int value1 = t1 == null ? 0 : t1.val;
        int value2 = t2 == null ? 0 : t2.val;
        root = new TreeNode(value1 + value2);
        TreeNode left1 = t1 == null ? null : t1.left;
        TreeNode left2 = t2 == null ? null : t2.left;
        TreeNode right1 = t1 == null ? null : t1.right;
        TreeNode right2 = t2 == null ? null : t2.right;
        TreeNode left = mergeTrees(left1, left2);
        TreeNode right = mergeTrees(right1, right2);
        root.left = left;
        root.right = right;
        return root;
    }
}