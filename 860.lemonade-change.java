/*
 * @lc app=leetcode id=860 lang=java
 *
 * [860] Lemonade Change
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length < 1) {
            return true;
        }
        int[] money = new int[3];
        for (int bill : bills) {
            if (bill == 5) {
                ++money[0];
            } else if (bill == 10) {
                if (money[0] >= 1) {
                    --money[0];
                    ++money[1];
                } else {
                    return false;
                }
            } else {
                if (money[0] >= 1 && money[1] >= 1) {
                    --money[0];
                    --money[1];
                    ++money[2];
                } else if (money[0] >= 3) {
                    money[0] -= 3;
                    ++money[2];
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

