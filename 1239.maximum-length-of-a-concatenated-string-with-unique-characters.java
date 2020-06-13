import java.awt.List;
import java.util.Arrays;

/*
 * @lc app=leetcode id=1239 lang=java
 *
 * [1239] Maximum Length of a Concatenated String with Unique Characters
 */

// @lc code=start
class Solution {

    private List<String> arr;
    private int ans = 0;

    public void dfs (int index, int len, int[] pre) {
        if (index >= arr.size()) {
            ans = Math.max(ans, len);
            return;
        }
        int[] tmp1 = Arrays.copyOfRange(pre, 0, 32);
        int[] tmp2 = Arrays.copyOfRange(pre, 0, 32);
        dfs(index+1, len, tmp1);
        for (char c : arr.get(index).toCharArray()) {
            int i = c - 'a';
            if (tmp2[i] == 1) {
                return;
            }
            tmp2[i] = 1;
        }
        dfs(index+1, len+arr.get(index).length(), tmp2);
    }

    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() < 1) {
            return 0;
        }
        this.arr = arr;
        dfs(0, 0, new int[32]);
        return ans;
    }
}
// @lc code=end

