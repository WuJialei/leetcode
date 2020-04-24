import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=863 lang=java
 *
 * [863] All Nodes Distance K in Binary Tree
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

    private HashMap<TreeNode, TreeNode> parent;
    private List<Integer> ans;
    private boolean[] visited;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parent = new HashMap<>();
        ans = new ArrayList<>();
        visited = new boolean[1005];
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        parent.put(root, new TreeNode(-1));
        TreeNode tNode = new TreeNode(-1);
        boolean flag = false;
        // 按层遍历，寻找目标节点，并且记录节点的父节点
        while (!queue.isEmpty()) {
            Queue<TreeNode> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.val == target.val) {
                    tNode = node;
                    flag = true;
                    break;
                }
                if (node.left != null) {
                    parent.put(node.left, node);
                    temp.offer(node.left);
                }
                if (node.right != null) {
                    parent.put(node.right, node);
                    temp.offer(node.right);
                }
            }
            if (flag) {
                break;
            }
            queue.addAll(temp);
        }
        int k = K;
        // 寻找目标节点的子节点里的k距离值
        dfs(tNode, k);
        int cnt = K;
        visited[tNode.val] = true;
        // 依次寻找目标节点的父节点里的k距离值，注意记忆化去重
        while (cnt > 0 && parent.get(tNode).val != -1) {
            tNode = parent.get(tNode);
            dfs(tNode, --cnt);
            visited[tNode.val] = true;
        }
        return ans;
    }

    public void dfs (TreeNode node, int num) {
        if (node == null || num < 0 || visited[node.val]) {
            return;
        }
        if (num == 0) {
            ans.add(node.val);
        }
        dfs(node.left, num-1);
        dfs(node.right, num-1);
    }

}
// @lc code=end

