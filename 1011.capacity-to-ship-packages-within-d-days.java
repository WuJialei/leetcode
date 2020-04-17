/*
 * @lc app=leetcode id=1011 lang=java
 *
 * [1011] Capacity To Ship Packages Within D Days
 */

// @lc code=start
class Solution {

    int[] weights;
    int d;

    public boolean Judge(int cnt) {
        int days = d;
        int k = cnt;
        for (int weight : weights) {
            if (days < 1 || weight > cnt) {
                return false;
            }
            if (k < weight) {
                k = cnt;
                --days;
            }
            k -= weight; 
        }
        return days > 0;
    }

    public int shipWithinDays(int[] weights, int D) {
        this.weights = weights;
        d = D;
        int left = 0;
        int right = 500 * 50000;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (!Judge(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
// @lc code=end

