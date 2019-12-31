import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=501 lang=java
 *
 * [501] Find Mode in Binary Search Tree
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

    int max;
    List<Integer> list;
    HashMap<Integer, Integer> map;

    public int[] findMode(TreeNode root) {
        list = new ArrayList<Integer>();
        max = 0;
        map = new HashMap<Integer, Integer>();
        inOrder(root);
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            if (set.getValue() == max) {
                list.add(set.getKey());
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public void inOrder (TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        max = Math.max(max, map.get(node.val));
        inOrder(node.right);
    }

}
// @lc code=end

