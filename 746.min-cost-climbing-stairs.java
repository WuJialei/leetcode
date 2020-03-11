/*
 * @lc app=leetcode id=746 lang=java
 *
 * [746] Min Cost Climbing Stairs
 */

// @lc code=start
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int a = cost[0];
        int b = cost[1];
        int c = 0;
        for (int i = 2; i < cost.length; ++i) {
            c = Math.min(a, b) + cost[i];
            a = b;
            b = c;
            
        }
        return Math.min(a, b);
    }
}
// @lc code=end

