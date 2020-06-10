import java.awt.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {

    private List<List<Integer>> ans;
    private int[] arrays;

    public void dfs (int index, List<Integer> list) {
        if (index >= arrays.length) {
            if (list.size() > 0) {
                // List<Integer> tmp = new ArrayList<>();
                // tmp.addAll(list);
                ans.add(list);
            }
            return;
        }
        List<Integer> l = new ArrayList<>();
        l.addAll(list);
        dfs(index+1, l);
        l = new ArrayList<>();
        l.addAll(list);
        l.add(arrays[index]);
        dfs(index+1, l);
        // list.remove(new Integer(arrays[index]));
    }

    public List<List<Integer>> subsets(int[] nums) {
        arrays = nums;
        ans = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return ans;
        }
        List<Integer> list = new ArrayList<>();
        ans.add(list);
        dfs(0, list);
        return ans;
    }
}
// @lc code=end

