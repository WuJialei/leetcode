import java.util.HashSet;

/*
 * @lc app=leetcode id=1110 lang=java
 *
 * [1110] Delete Nodes And Return Forest
 */

// @lc code=start
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

    HashSet<Integer> set;
    List<TreeNode> ans;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set = new HashSet<Integer>();
        ans = new ArrayList<TreeNode>();
        for (int i : to_delete) {
            set.add(i);
        }
        if (root == null) {
            return ans;
        }
        root = dfs(root);
        if (root != null) {
            ans.add(root);
        }
        return ans;
    }

    // 若当前节点是删除点，返回null；不是删除点，返回当前节点（子节点删除与否判断完成）
    public TreeNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }
        node.left = dfs(node.left);
        node.right = dfs(node.right);
        // 节点要删（要删才会产生新树）
        if (set.contains(node.val)) {
            if (node.left != null) {
                ans.add(node.left);
            }
            if (node.right != null) {
                ans.add(node.right);
            }
            return null;
        } else {
            return node;
        }
    }

}
// @lc code=end

