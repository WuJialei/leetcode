import java.util.ArrayList;
import java.util.List;

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

    public void inOrder (TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inOrder(root1, list1);
        inOrder(root2, list2);
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            int a = list1.get(i);
            int b = list2.get(j);
            if (a < b) {
                ans.add(a);
                ++i;
            } else {
                ans.add(b);
                ++j;
            }
        }
        while (i < list1.size()) {
            ans.add(list1.get(i++));
        }
        while (j < list2.size()) {
            ans.add(list2.get(j++));
        }
        return ans;
    }
}