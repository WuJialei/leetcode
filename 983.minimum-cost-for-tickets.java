/*
 * @lc app=leetcode id=983 lang=java
 *
 * [983] Minimum Cost For Tickets
 */

// @lc code=start
class Solution {
    int[] days;
    int[] costs;
    Integer[] memory;
    int[] durations = {1, 7, 30};

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        memory = new Integer[days.length];
        return dp(0);
    }

    // dp(i)表示从day[i]到最后的最小花费
    public int dp (int i) {
        if (i >= days.length) {
            return 0;
        }
        if (memory[i] != null) {
            return memory[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = 0; k < 3; ++k) {
            int j = i;
            while (j < days.length && days[j] < days[i] + durations[k]) {
                ++j;
            }
            ans = Math.min(ans, dp(j) + costs[k]);
        }
        memory[i] = ans;
        return ans;
    }

}
// @lc code=end

