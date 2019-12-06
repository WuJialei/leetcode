import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int cnt = 2;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) {
            return ans;
        }
        queue.offer(root);
        List<Integer> tmp = new ArrayList<Integer>();
        tmp.add(root.val);
        ans.add(tmp);
        while (!queue.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }                                
            }
            tmp = new ArrayList<Integer>();
            int len = list.size();
            if (cnt % 2 == 0) {
                for (int i = len - 1; i >= 0; --i){
                    tmp.add(list.get(i).val);
                    queue.offer(list.get(len-1-i));
                }
            } else {
                for (int i = 0; i < len; ++i){
                    tmp.add(list.get(i).val);
                    queue.offer(list.get(i));
                }
            }
            ++cnt;
            if(tmp.size() > 0) {
                ans.add(tmp);
            }
            
        }
        return ans;
    }
}
// @lc code=end

