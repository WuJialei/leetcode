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

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> arrays = new ArrayList<>();
        arrays = innerSort(root);
        int len = arrays.size();
        for (int i = 0, j = len-1; i < j;) {
        	if (arrays.get(i) + arrays.get(j) == k) {
        		return true;
        	} else if(arrays.get(i) + arrays.get(j) < k) {
                ++i;
            } else {
                --j;
            }
        }
        return false;
    }

    public List<Integer> innerSort(TreeNode node) {
        sortArrays = new ArrayList<>();
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