/*
 * @lc app=leetcode id=1323 lang=java
 *
 * [1323] Maximum 69 Number
 */

// @lc code=start
class Solution {
    public int maximum69Number (int num) {
        String number = String.valueOf(num);
        for (int i = 0; i < number.length(); ++i) {
            if (number.charAt(i) == '6') {
                number = number.substring(0, i) + '9' + number.substring(i+1, number.length());
                break;
            }
        }
        return Integer.parseInt(number);
    }
}
// @lc code=end

