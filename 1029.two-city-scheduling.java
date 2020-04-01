/*
 * @lc app=leetcode id=1029 lang=java
 *
 * [1029] Two City Scheduling
 */

// @lc code=start
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        // 所有人(2N)都先飞往a城市，然后从中选出N个人飞往b城市
        // 飞往a城市总费用每个人去a的和，选出的人飞往b城市的费用为b[i]-a[i]
        // 飞往a的总费用是个常数，所以要使得选出的飞往b城市的n个人的费用最小
        Arrays.sort(
            costs,
            (a, b) -> (a[1] - a[0]) - (b[1] - b[0])
        );
        int ans = 0;
        for (int i = 0; i < costs.length; ++i) {
            if (i < costs.length/2) {
                ans += costs[i][1];
            } else {
                ans += costs[i][0];
            }
        }
        return ans;
    }
}
// @lc code=end

