/*
 * @lc app=leetcode id=767 lang=java
 *
 * [767] Reorganize String
 */

// @lc code=start
class Solution {
    public String reorganizeString(String S) {
        int[] arrays = new int[26];
        int index = 0;
        int maxLen = 0;
        int len = S.length();
        for (char c : S.toCharArray()) {
            ++arrays[c - 'a'];
            if (arrays[c-'a'] > maxLen) {
                maxLen = arrays[c-'a'];
                index = c - 'a';
            }
        }
        if (maxLen > (len + 1)/2) {
            return "";
        }
        // 先按奇数来，把空插好（前提是如果有等于（len+1）/2的必须提前隔空插好）
        char[] ans = new char[len];
        int odd = 1, even = 0;
        if (maxLen == (len+1)/2) {
            while(arrays[index] > 0) {
                ans[even] = (char)(index + 'a');
                even += 2;
                arrays[index]--;
            }
        } 
        for (int i = 0; i < 26; ++i) {
            while (arrays[i] > 0 && odd < len) {
                ans[odd] = (char)(i + 'a');
                odd += 2;
                arrays[i]--;
            }
            while (arrays[i] > 0) {
                ans[even] = (char)(i + 'a');
                even += 2;
                arrays[i]--;
            }
        }
        return new String(ans);
    }
}
// @lc code=end

