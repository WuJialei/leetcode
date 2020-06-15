/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] data = new int[rowIndex + 1];
        Arrays.fill(data, 1);
        for (int i = 1; i <= rowIndex; ++i) {
            for (int j = i-1; j >= 1; --j) {
                data[j] = data[j] + data[j-1];
            }
        }
        List<Integer> ans= new ArrayList<>();
        for (int num : data) {
            ans.add(num);
        }
        return ans;
    }
}
// @lc code=end

