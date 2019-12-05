/*
 * @lc app=leetcode id=636 lang=java
 *
 * [636] Exclusive Time of Functions
 */

// @lc code=start
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        // start相当于{, end相当于}
        // {}一定是成对出现成对消除的，即出现顺序符合{}的消除
        int[] ans = new int[n];
        int last = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (String log : logs) {
            String[] strs = log.split(":");
            int id = Integer.parseInt(strs[0]);
            int cur = Integer.parseInt(strs[2]);
            if (strs[1].equals("start")) {
                if (!stack.isEmpty()) {
                    ans[stack.peek()] += cur - last;
                }
                stack.push(id);
                last = cur;
            } else {
                ans[stack.pop()] += cur - last + 1;
                last = cur + 1;
            }
        }
        return ans;
    }
}
// @lc code=end

