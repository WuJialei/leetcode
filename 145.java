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

	private List<Integer> ret;

    public List<Integer> postorderTraversal(TreeNode root) {
    	/*
        ret = new ArrayList<Integer>();
        if (root == null) {
        	return ret;
        }
        dfs(root);
        return ret;
        */
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        TreeNode last = null;
        Stack<TreeNode> stack = new Stack<>();
        while(cur != null || !stack.isEmpty()) {
        	while(cur != null) {
        		stack.push(cur);
        		cur = cur.left;
        	}
        	cur = stack.peek();
        	if (cur.right == null || cur.right == last) {
        		result.add(cur.val);
        		stack.pop();
        		last = cur;
        		cur = null;
        	} else {
        		cur = cur.right;
        	}
        }
        return result;
    }


    public void dfs(TreeNode node) {
    	if (node == null) {
    		return;
    	}
    	if (node.left != null) {
    		dfs(node.left);
    	}
    	if (node.right != null) {
    		dfs(node.right);
    	}
    	ret.add(node.val);
    }

}