import java.awt.List;

/*
 * @lc app=leetcode id=653 lang=java
 *
 * [653] Two Sum IV - Input is a BST
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

    List<Integer> list;
    int k;
    public boolean findTarget(TreeNode root, int k) {
        list = new ArrayList<Integer>();
        this.k = k;
        order(root);
        return dfs(0, list.size() - 1);
    }

    public void order(TreeNode node) {
        if (node == null) {
            return;
        }
        order(node.left);
        list.add(node.val);
        order(node.right);
    }

    public boolean dfs (int start, int end) {
        if (start >= end) {
            return false;
        }
        if (list.get(start) + list.get(end) == k) {
            return true;
        } else if (list.get(start) + list.get(end) < k) {
            return dfs (start + 1, end);
        } else {
            return dfs (start, end - 1);
        }
    }

}
// @lc code=end

