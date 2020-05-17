import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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

    private List<List<Integer>> ans;

    public void dfs (TreeNode node, int cnt, List<Integer> tmp) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (cnt - node.val == 0) {
                tmp.add(node.val);
                // List<Integer> t = new ArrayList<>();
                // for (int v : tmp) {
                //     t.add(v);
                // }
                ans.add(new ArrayList<>(tmp));
                tmp.remove(tmp.size()-1);                
            }
            return;
        }
        tmp.add(node.val);
        if (node.left != null) {
            dfs(node.left, cnt - node.val, tmp);
        }
        if (node.right != null) {
            dfs(node.right, cnt - node.val, tmp);
        }
        tmp.remove(tmp.size()-1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<Integer> list = new ArrayList<>();
        dfs(root, sum, list);
        return ans;
    }
}
// @lc code=end

