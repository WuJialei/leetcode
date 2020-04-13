/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input array is sorted
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int len = numbers.length;
        for (int i = 0, j = len - 1; i < len && j >= 0;) {
            if (numbers[i] + numbers[j] == target) {
                ans[0] = i + 1;
                ans[1] = j + 1;
                break;
            } else if (numbers[i] + numbers[j] > target) {
                --j;
            } else {
                ++i;
            }
        }
        return ans;
    }
}
// @lc code=end

