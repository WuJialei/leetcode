/*
 * @lc app=leetcode id=274 lang=java
 *
 * [274] H-Index
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int cnt = 0;
        int len = citations.length;
        while (cnt < len && citations[len-1-cnt] > cnt) {
            cnt++;
        }
        return cnt;
    }
}
// @lc code=end

