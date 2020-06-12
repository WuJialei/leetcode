/*
 * @lc app=leetcode id=318 lang=java
 *
 * [318] Maximum Product of Word Lengths
 */

// @lc code=start
class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length < 1) {
            return 0;
        }
        int ans = 0;
        // 用int的每一位代表对应的26个字母
        // 用两个数的与值是否为0来判断两个字符串是否有相同字母
        int[] word2bit = new int[words.length];
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words[i].length(); ++j) {
                word2bit[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        for (int i = 0; i < word2bit.length; ++i) {
            for (int j = i + 1; j < word2bit.length; ++j) {
                if ((word2bit[i] & word2bit[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}
// @lc code=end

