/*
 * @lc app=leetcode id=894 lang=java
 *
 * [894] All Possible Full Binary Trees
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

    HashMap<Integer, List<TreeNode>> map = new HashMap<Integer, List<TreeNode>>();

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (N == 1) {
            list.add(new TreeNode(0));
            return list;
        } else if (N%2 == 1) {
            for(int i = 1; i < N; i = i + 2) {
                boolean f1 = map.containsKey(i);
                List<TreeNode> left =  f1 ? map.get(i) : allPossibleFBT(i);
                if (!f1) {
                    map.put(i, left);
                }
                boolean f2 = map.containsKey(N - i - 1);
                List<TreeNode> right = f2 ? map.get(N - i - 1): allPossibleFBT(N - i - 1);
                if (!f2) {
                    map.put(N - i - 1, right);
                }
                for (TreeNode a : left) {
                    for (TreeNode b : right) {
                        TreeNode root = new TreeNode(0);
                        root.left = a;
                        root.right = b;
                        list.add(root);
                    }
                }
                                
            }
        }
        return list;
    }
}
// @lc code=end

