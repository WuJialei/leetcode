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

	private int maxValue = 0;

	/*
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        maxValue = Math.max(maxValue, getNodeDiameter(root));
        maxValue = Math.max(maxValue, diameterOfBinaryTree(root.left));
        maxValue = Math.max(maxValue, diameterOfBinaryTree(root.right));
        return maxValue;
    }

    public int getNodeDiameter(TreeNode root) {
    	if (root == null) {
        	return 0;
        }
        int leftDiameter = getSubtreeDepth(root.left);
        int rightDiameter = getSubtreeDepth(root.right);
        return leftDiameter + rightDiameter;
    }

    public int getSubtreeDepth(TreeNode node) {
    	if (node == null) {
    		return 0;
    	}
    	return 1 + Math.max(getSubtreeDepth(node.left), getSubtreeDepth(node.right));
    }
    */

    public int diameterOfBinaryTree(TreeNode root) {
    	getTreeDepth(root);
    	return maxValue;
    }

    public int getTreeDepth(TreeNode node) {
    	if (node == null) {
    		return 0;
    	}
    	int leftDepth = getTreeDepth(node.left);
    	int rightDepth = getTreeDepth(node.right);
    	maxValue = Math.max(maxValue, leftDepth + rightDepth);
    	return 1 + Math.max(leftDepth, rightDepth);
    }

}