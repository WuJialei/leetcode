import java.util.List;

/*
 * @lc app=leetcode id=1104 lang=java
 *
 * [1104] Path In Zigzag Labelled Binary Tree
 */

// @lc code=start
class Solution {

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new ArrayList<Integer>();
        while (label >= 1) {
            list.add(label);
            label /= 2;
        }
        Collections.reverse(list);
        List<Integer> ans = new ArrayList<Integer>();
        boolean flag = true;
        for (int i = list.size() - 1; i >= 0; --i) {
            if (flag) {
                ans.add(list.get(i));
            } else {
                int tmp = (new Double(Math.pow(2, i))).intValue();
                ans.add(3*tmp - 1 - list.get(i));
            }
            flag = !flag;
        }
        Collections.reverse(ans);
        return ans;
    }
}
// @lc code=end

