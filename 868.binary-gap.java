/*
 * @lc app=leetcode id=868 lang=java
 *
 * [868] Binary Gap
 */

// @lc code=start
class Solution {
    public int binaryGap(int N) {
        int[] nums = new int[32];
        int cnt = 31;
        while (cnt >= 0) {
            if ((N&1) == 1) {
                nums[cnt] = 1;
            }
            N >>= 1;
            --cnt;
        }
        int pre = 0;
        int ans = 0;
        for (; pre < nums.length; ++pre) {
            if (nums[pre] == 1) {
                break;
            }
        }
        for (int cur = pre + 1; cur < nums.length; ++cur) {
            if (nums[cur] == 1) {
                ans = Math.max(ans, cur - pre);
                pre = cur;
            }
        }
        return ans;
    }
}
// @lc code=end

