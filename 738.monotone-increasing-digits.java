import java.util.Stack;

/*
 * @lc app=leetcode id=738 lang=java
 *
 * [738] Monotone Increasing Digits
 */

// @lc code=start
class Solution {
    public int monotoneIncreasingDigits(int N) {
        if (N < 10) {
            return N;
        }
        char[] s = String.valueOf(N).toCharArray();
        int len = s.length;
        int index = -1;
        // 从右向左寻找第一个下降且不会因为下降导致前面非降序的位置
        for (int i = len - 2; i >= 0; --i) {
            if (s[i] > s[i+1]) {
                index = i;
                s[i] = (char)((int)s[i] - 1);
            }
        }
        if (index >= 0) {
            while (index+1 < len) {
                s[index+1] = '9';
                ++index;
            }
        }
        return Integer.valueOf(new String(s));
    }
}
// @lc code=end

