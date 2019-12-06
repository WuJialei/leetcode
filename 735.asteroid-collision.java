import java.awt.List;

/*
 * @lc app=leetcode id=735 lang=java
 *
 * [735] Asteroid Collision
 */

// @lc code=start
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int ast : asteroids) {
            if (stack.isEmpty()) {
                stack.push(ast);
            } else {
                while (!stack.isEmpty()) {
                    int top = stack.peek();
                    if (top * ast > 0) {
                        stack.push(ast);
                        break;
                    } else {
                        if (top > 0 && ast < 0) {
                            if (top < -ast) {
                                stack.pop();
                                if (stack.isEmpty()) {
                                    stack.push(ast);
                                    break;
                                }
                            } else if (top == -ast) {
                                stack.pop();
                                break;
                            } else {
                                break;
                            }
                        } else {
                            stack.push(ast);
                            break;
                        }
                    }
                }
            }
        }
        int len = stack.size();
        int[] ans = new int[len];
        for (int i = len-1; i >= 0; --i) {
            ans[i] = stack.pop();
        }

        return ans;
    }
}
// @lc code=end

