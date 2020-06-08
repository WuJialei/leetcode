/*
 * @lc app=leetcode id=405 lang=java
 *
 * [405] Convert a Number to Hexadecimal
 */

// @lc code=start
class Solution {
    public String toHex(int num) {
        int[] arrays = new int[32];
        int cnt = 31;
        while (cnt >= 0) {
            arrays[cnt] = num & 1;
            num >>= 1;
            --cnt;
        }
        char[] ans = new char[8];
        for (int i = 0; i < ans.length; ++i) {
            int sum = 0;
            int j = i * 4;
            int k = i * 4 + 3;
            while (j <= k) {
                sum = sum * 2 + arrays[j];
                ++j;
            }
            if (sum < 10) {
                ans[i] = (char)('0' + sum);
            } else {
                ans[i] = (char)('a' + (sum - 10));
            }
        }
        int l = 0;
        for (; l < ans.length; ++l) {
            if (ans[l] != '0') {
                break;
            }
        }
        if (l >= ans.length - 1) {
            return "" + ans[ans.length-1];
        } else {
            String ret = "";
            while(l < ans.length) {
                ret = ret + ans[l];
                ++l;
            }
            return ret;
        }
    }
}
// @lc code=end

