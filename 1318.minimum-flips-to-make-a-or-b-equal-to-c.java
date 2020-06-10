/*
 * @lc app=leetcode id=1318 lang=java
 *
 * [1318] Minimum Flips to Make a OR b Equal to c
 */

// @lc code=start
class Solution {

    public int[] int2bit(int val) {
        int[] ret = new int[32];
        int cnt = 31;
        while (cnt >= 0) {
            ret[cnt] = val & 1;
            val >>= 1;
            --cnt;
        }
        return ret;
    }

    public int minFlips(int a, int b, int c) {
        int[] aa = int2bit(a);
        int[] bb = int2bit(b);
        int[] cc = int2bit(c);
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            if ((aa[i] | bb[i]) == cc[i]) {
                continue;
            } else {
                ans += (aa[i] & bb[i]) == 1? 2 : 1;
            }
        }
        return ans;
    }
}
// @lc code=end

