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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null){
        	return res;
        }
        String rootPath = String.valueOf(root.val);
        if(root.left == null && root.right == null){
        	res.add(rootPath);
        }
        if(root.left != null){
        	dfs(root.left, res, rootPath);
        }
        if(root.right != null){
        	dfs(root.right, res, rootPath);
        }        
        return res;
    }

    public void dfs(TreeNode rootTemp, List<String> response, String pre){
    	if(rootTemp == null){
    		return;
    	}
    	String path = pre + "->" + rootTemp.val;
    	if(rootTemp.left == null && rootTemp.right == null){
    		response.add(path);
    	}
    	if(rootTemp.left != null){
    		dfs(rootTemp.left, response, path);
    	}
    	if(rootTemp.right != null){
    		dfs(rootTemp.right, response, path);
    	}
    	
    }
}