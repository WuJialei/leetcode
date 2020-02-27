/*
 * @lc app=leetcode id=976 lang=java
 *
 * [976] Largest Perimeter Triangle
 */

// @lc code=start
class Solution {
    public int largestPerimeter(int[] A) {
        int index = A.length - 1;
        Arrays.sort(A);
        while (index - 2 >= 0) {
            if (A[index-2] + A[index - 1] > A[index]) {
                return A[index-2] + A[index - 1] + A[index];
            } else {
                --index;
            }
        }
        return 0;
    }
}
// @lc code=end

