/*
 * @lc app=leetcode id=1209 lang=java
 *
 * [1209] Remove All Adjacent Duplicates in String II
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Stack<Integer>> map = new HashMap<Character, Stack<Integer>>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                if (!map.containsKey(c)) {
                    Stack<Integer> sk = new Stack<Integer>();
                    map.put(c, sk);
                }
                map.get(c).push(1);
            } else {
                if (c == stack.peek()) {
                    if (map.get(c).peek() == k-1) {
                        int cnt = k - 1;
                        while(cnt > 0) {
                            stack.pop();
                            --cnt;
                        }
                        map.get(c).pop();
                    } else {
                        stack.push(c);
                        // map.put(c, map.get(c).pop() + 1);
                        map.get(c).push(map.get(c).pop() + 1);
                    }
                } else {
                    stack.push(c);
                    if (!map.containsKey(c)) {
                        Stack<Integer> sk = new Stack<Integer>();
                        map.put(c, sk);
                    }
                    map.get(c).push(1);
                }

            }
        }
        String ans = new String("");
        while(!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        return ans;
    }
}
// @lc code=end

