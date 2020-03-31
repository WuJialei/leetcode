/*
 * @lc app=leetcode id=1221 lang=java
 *
 * [1221] Split a String in Balanced Strings
 */

// @lc code=start
class Solution {
    public int balancedStringSplit(String s) {
        int left = 0;
        int right = 0;
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                ++left;
            }
            if (c == 'R') {
                ++right;
            }
            if (left > 0 && left == right) {
                ++ans;
                left = 0;
                right = 0;
            }
        }
        return ans;
    }
}
// @lc code=end

