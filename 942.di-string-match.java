import java.util.Arrays;

/*
 * @lc app=leetcode id=942 lang=java
 *
 * [942] DI String Match
 */

// @lc code=start
class Solution {
    public int[] diStringMatch(String S) {
        if (S == null || S.length() < 1) {
            return new int[0];
        }
        int len = S.length();
        int[] ans = new int[len+1];
        Arrays.fill(ans, -1);
        int k = 0;
        for (int i = 0; i < len; ++i) {
            if (S.charAt(i) == 'D') {
               k++;
            }
        }
        int cnt = k;
        for (int i = 0; i < len; ++i) {
            if (S.charAt(i) == 'D') {
               ans[i+1] = --k;
            }
        }
        for (int i = 0; i < ans.length; ++i) {
            if (ans[i] == -1) {
                ans[i] = cnt++;
            }
        }
        return ans;
    }
}
// @lc code=end

