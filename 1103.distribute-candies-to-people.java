/*
 * @lc app=leetcode id=1103 lang=java
 *
 * [1103] Distribute Candies to People
 */

// @lc code=start
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int n = num_people;
        int sum = candies;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            if (sum > i + 1) {
                ans[i] = i + 1;
                sum -= i + 1;
            } else {
                ans[i] = sum;
                return ans;
            }
        }
        int k = 1;
        while (sum > 0) {
            for (int i = 0; i < n; ++i) {
                int num = k * n + i + 1;
                if (sum > num) {
                    ans[i] += num;
                } else {
                    ans[i] += sum;
                    return ans;
                }
                sum -= num;
            }
            k++;
        }
        return ans;
    }
}
// @lc code=end

