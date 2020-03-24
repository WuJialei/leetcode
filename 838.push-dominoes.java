/*
 * @lc app=leetcode id=838 lang=java
 *
 * [838] Push Dominoes
 */

// @lc code=start
class Solution {
    public String pushDominoes(String dominoes) {
        if (dominoes == null || dominoes.length() < 1) {
            return "";
        }
        int n = dominoes.length();
        int[] indexes = new int[n+2];
        char[] symbols = new char[n+2];
        char[] ans = dominoes.toCharArray();
        int len = 0;
        // 加一个头，不影响全局
        indexes[len] = -1;
        symbols[len++] = 'L'; 
        for (int i = 0; i < n; ++i) {
            if (ans[i] != '.') {
                indexes[len] = i;
                symbols[len++] = ans[i];
            }
        }
        // 加一个尾，不影响全局
        indexes[len] = n;
        symbols[len] = 'R';
        for (int i = 0; i < len; ++i) {
            int x = indexes[i];
            int y = indexes[i+1];
            char a = symbols[i];
            char b = symbols[i+1];
            if (a == b) {
                // L...L or R....R
                for (int k = x + 1; k < y; ++k) {
                    ans[k] = a;
                }
            } else if (a > b) {
                // R.....L
                for (int k = x + 1; k < y; ++k) {
                    ans[k] = k-x==y-k ? '.' : k-x < y-k ? 'R': 'L';
                }
            }
        }
        return new String(ans);
    }
}
// @lc code=end

