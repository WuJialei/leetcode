/*
 * @lc app=leetcode id=880 lang=java
 *
 * [880] Decoded String at Index
 */

// @lc code=start
class Solution {
    public String decodeAtIndex(String S, int K) {
        long cnt = 0;
        for (char c : S.toCharArray()) {
            if (Character.isDigit(c)) {
                cnt *= c - '0';
            }
            else {
                ++cnt;
            }
        }
        int end = S.length() - 1;
        while (end >= 0) {
            char c = S.charAt(end);
            if (Character.isDigit(c)) {
                cnt /= c - '0';
                K %= cnt;
            } else {
                if (K % cnt == 0) {
                    return S.substring(end, end+1);
                }
                --cnt;
            }
            --end;
        }
        return "";
    }
}
// @lc code=end

