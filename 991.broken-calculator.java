import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode id=991 lang=java
 *
 * [991] Broken Calculator
 */

// @lc code=start
class Solution {

    public int brokenCalc(int X, int Y) {
        int x = X;
        int y = Y;
        int cnt = 0;
        while (x < y) {
            if (y%2 == 0) {
                y /= 2;
            } else {
                ++y;
            }
            ++cnt;
        }
        return cnt + x - y;
    }

}
// @lc code=end

