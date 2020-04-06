/*
 * @lc app=leetcode id=1247 lang=java
 *
 * [1247] Minimum Swaps to Make Strings Equal
 */

// @lc code=start
class Solution {
    public int minimumSwap(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return -1;
        }
        int x_y = 0;
        int y_x = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) == 'x') {
                    ++x_y;
                } else {
                    ++y_x;
                }
            }
        }
        return (x_y%2 == y_x%2) ? ((x_y/2) + (y_x/2) + (x_y%2)*2): -1;
    }
}
// @lc code=end

