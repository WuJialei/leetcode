/*
 * @lc app=leetcode id=385 lang=java
 *
 * [385] Mini Parser
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {

        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        StringBuilder str = new StringBuilder("");
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack.push(new NestedInteger());
            } else if ((c >= '0' && c <= '9') || (c == '-')) {
                str.append(c);
            } else {
                if (str.toString().length() > 0) {
                    NestedInteger n = stack.peek();
                    n.add(new NestedInteger(Integer.parseInt(str.toString())));
                    str = new StringBuilder("");
                }
                if (c == ']') {
                    NestedInteger n = stack.pop();
                    if (stack.isEmpty()) {
                        return n;
                    }
                    NestedInteger last = stack.peek();
                    last.add(n);
                }
            }
        }
        if (str.toString().length() > 0) {
            return new NestedInteger(Integer.parseInt(str.toString()));
        }
        return stack.peek();

    }
}
// @lc code=end

