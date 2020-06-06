import java.util.Arrays;

/*
 * @lc app=leetcode id=389 lang=java
 *
 * [389] Find the Difference
 */

// @lc code=start
class Solution {
    public char findTheDifference(String s, String t) {
        if (s == null || t == null || s.length() + 1 != t.length()) {
            return ' ';
        }
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        for (int i = 0; i < ss.length; ++i) {
            if (ss[i] != tt[i]) {
                return tt[i];
            }
        }
        return tt[tt.length-1];
    }
}
// @lc code=end

