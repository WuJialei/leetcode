/*
 * @lc app=leetcode id=1130 lang=java
 *
 * [1130] Minimum Cost Tree From Leaf Values
 */

// @lc code=start
class Solution {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(Integer.MAX_VALUE);
        int res = 0;
        for (int num : arr) {
            // 对于出现在小于它的数，都要将该数去除，即为寻找该数左右最小的数
            while (num >= stack.peek()) {
                int little = stack.pop();
                res += little * Math.min(num, stack.peek());
            }
            stack.push(num);
        }
        while (stack.size() > 2) {
            int top = stack.pop();
            res += top * stack.peek();
        }
        return res;
    }
}
// @lc code=end

