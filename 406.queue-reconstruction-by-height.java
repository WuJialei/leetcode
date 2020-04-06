import java.util.LinkedList;

/*
 * @lc app=leetcode id=406 lang=java
 *
 * [406] Queue Reconstruction by Height
 */

// @lc code=start
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(
            people,
            (a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return b[0] - a[0];
                }
            }
        );
        // 身高降序，索引升序
        // 按照索引插入，因为身高是升序，所以在它之后插入的都比它小
        LinkedList<int[]> ans = new LinkedList<>();
        for (int[] p : people) {
            ans.add(p[1], p);
        }
        return ans.toArray(new int[people.length][2]);
    }
}
// @lc code=end

