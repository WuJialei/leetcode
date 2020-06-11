import java.util.HashSet;

/*
 * @lc app=leetcode id=421 lang=java
 *
 * [421] Maximum XOR of Two Numbers in an Array
 */

// @lc code=start
class Solution {
    public int findMaximumXOR(int[] nums) {
        int mask = 0;
        // ans = a ^ b
        int ans = 0;
        int cnt = 31;
        while (cnt >= 0) {
            mask += 1 << cnt;
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }
            ans += 1 << cnt;
            boolean flag = false;
            for (int num : set) {
                if (set.contains(num ^ ans)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                ans -= 1 << cnt;
            }            
            --cnt;
        }
        return ans;
    }
}
// @lc code=end

