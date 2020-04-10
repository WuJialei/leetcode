import java.util.Arrays;

/*
 * @lc app=leetcode id=881 lang=java
 *
 * [881] Boats to Save People
 */

// @lc code=start
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int cnt = 0;
        int len = people.length;
        int i = len - 1;
        int j = 0;
        for (; i >= j; --i) {
            if (people[i] + people[j] <= limit) {
                ++j;
            }
            ++cnt;
        }
        return cnt;
    }
}
// @lc code=end

