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

	private int sumKeys = 0;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode node) {
    	if (node == null) {
    		return;
    	}
    	if (node.right != null) {
    		dfs(node.right);
    	}
    	sumKeys += node.val;
        node.val = sumKeys;
    	if (node.left != null) {
    		dfs(node.left);
    	}
    }

}