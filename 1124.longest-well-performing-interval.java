/*
 * @lc app=leetcode id=1124 lang=java
 *
 * [1124] Longest Well-Performing Interval
 */

// @lc code=start
class Solution {
    public int longestWPI(int[] hours) {
        int ans = 0;
        for (int i = 0; i < hours.length; ++i) {
            if (hours[i] > 8) {
                hours[i] = 1;
            } else {
                hours[i] = -1;
            }
        }
        int[] preSum = new int[hours.length + 1];
        preSum[0] = 0;
        for (int i = 1; i <= hours.length; ++i) {
            preSum[i] = preSum[i-1] + hours[i-1];
        }
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < preSum.length; ++i) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else if (preSum[i] < preSum[stack.peek()]) {
                stack.push(i);
            }
        }
        for (int i = preSum.length - 1; i >= 0; --i) {
            int last = i;
            while (!stack.isEmpty() && preSum[stack.peek()] < preSum[i]) {
                last = stack.pop();
            }
            if (last != i) {
                ans = Math.max(ans, i - last);
            }
        }
        return ans;
    }
}
// @lc code=end

