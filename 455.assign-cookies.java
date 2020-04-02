import java.util.Arrays;

/*
 * @lc app=leetcode id=455 lang=java
 *
 * [455] Assign Cookies
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || g.length < 1 || s == null || s.length < 1){
            return 0;
        }
        int m = g.length;
        int n = s.length;
        int i = 0; 
        int j = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (; i < m; ) {
            if (j < n) {
                if (g[i] <= s[j]) {
                    ++i;
                    ++j;
                } else {
                    ++j;
                }
            } else {
                break;
            }
        }
        return i;
    }
}
// @lc code=end

