import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=971 lang=java
 *
 * [971] Flip Binary Tree To Match Preorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private int[] arrays;
    private List<Integer> ans;
    private int index;

    public void dfs (TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.val != arrays[index++]) {
            ans.clear();
            ans.add(-1);
            return;
        }
        if ((node.left != null) && (index < arrays.length) && (node.left.val != arrays[index])) {
            ans.add(node.val);
            dfs(node.right);
            dfs(node.left);
        } else {
            dfs(node.left);
            dfs(node.right);
        }
    }

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        arrays = voyage;
        ans = new ArrayList<>();
        index = 0;
        dfs(root);
        if (!ans.isEmpty() && (ans.get(0) == -1)) {
            ans.clear();
            ans.add(-1);
            return ans;
        } else {
            return ans;
        }
    }
}
// @lc code=end

