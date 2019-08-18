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

	private List<Integer> sortArrays;

    public int getMinimumDifference(TreeNode root) {
        List<Integer> arrays = new ArrayList<>();
        arrays = innerSort(root);
        int minValue = Integer.MAX_VALUE;
        for (int i = 1; i < arrays.size(); ++i) {
        	minValue = Math.min(minValue, arrays.get(i) - arrays.get(i-1));
        }
        return minValue;
    }

    public List<Integer> innerSort(TreeNode node) {
    	sortArrays = new ArrayList<Integer>();
    	dfs(node);
    	return sortArrays;
    }

    public void dfs(TreeNode node) {
    	if (node == null) {
    		return;
    	}
    	dfs(node.left);
    	sortArrays.add(node.val);
    	dfs(node.right);
    }

}