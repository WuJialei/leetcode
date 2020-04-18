/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 */

// @lc code=start
class Solution {

    private int[] piles;

    public int count (int speed) {
        int ans = 0;
        for (int pile : piles) {
            if (pile <= speed) {
                ++ans;
            } else {                
                int temp = (pile % speed) ==0 ? pile/speed: pile/speed + 1;
                ans += temp;
            }
        }
        return ans;
    }

    public int minEatingSpeed(int[] piles, int H) {
        this.piles = piles;
        int left = 1;
        int right = 1000_000_000;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (count(mid) > H) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
// @lc code=end

