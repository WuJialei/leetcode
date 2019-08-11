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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
        	return true;
        }
        int leftHeight = cntHeight(root.left);
        int rightHeight = cntHeight(root.right);
        return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(leftHeight - rightHeight) <= 1);
    }

    public int cntHeight(TreeNode node) {
    	if (node == null) {
    		return 0;
    	}
    	return Math.max(cntHeight(node.left), cntHeight(node.right)) + 1;
    }

}