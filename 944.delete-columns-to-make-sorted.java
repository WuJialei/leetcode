/*
 * @lc app=leetcode id=944 lang=java
 *
 * [944] Delete Columns to Make Sorted
 */

// @lc code=start
class Solution {
    public int minDeletionSize(String[] A) {
        int m = A.length;
        int n = A[0].length();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                if (A[j].charAt(i) < A[j-1].charAt(i)) {
                    ++ans;
                    break;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

