/*
 * @lc app=leetcode id=1048 lang=java
 *
 * [1048] Longest String Chain
 */

// @lc code=start
class Solution {
    public int longestStrChain(String[] words) {
        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);
        Arrays.sort(
            words,
            (a, b) -> a.length() - b.length()
        );
        int ans = 1;
        // dp[i]表示以第i位置结尾的字符串链长度
        for (int i = 1; i < words.length; ++i) {
            for (int j = i-1; j >= 0; --j) {
                if (words[j].length() ==  words[i].length()) {
                    continue;
                } else if (words[j].length() + 1 <  words[i].length()) {
                    break;
                }
                if (compare(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public boolean compare (String str1, String str2) {
        int j = 0;
        for (int i = 0; i < str2.length() && j < str1.length(); ++i) {
            if (str1.charAt(j) == str2.charAt(i)) {
                ++j;
            }
        }
        return j == str1.length();
    }

}
// @lc code=end

