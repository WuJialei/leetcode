import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode id=401 lang=java
 *
 * [401] Binary Watch
 */

// @lc code=start
class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<>();
        for (int hour = 0; hour < 12; ++hour) {
            for (int minute = 0; minute < 60; ++minute) {
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == num) {
                    ans.add(String.format("%d:%02d", hour, minute));
                }
            }
        }
        return ans;
    }
}
// @lc code=end

