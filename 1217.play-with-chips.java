/*
 * @lc app=leetcode id=1217 lang=java
 *
 * [1217] Play with Chips
 */

// @lc code=start
class Solution {
    public int minCostToMoveChips(int[] chips) {
        int odd = 0;
        int even = 0;
        // 偶数位置的棋子都是等价的，奇数位置的棋子都是等价的
        for (int chip : chips) {
            if (chip % 2 == 0) {
                ++even;
            } else {
                ++odd;
            }
        }
        return Math.min(odd, even);
    }
}
// @lc code=end

