import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode id=870 lang=java
 *
 * [870] Advantage Shuffle
 */

// @lc code=start
class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        int len = A.length;
        int[][] BB = new int[len][2];
        for (int i = 0; i < len; ++i) {
            BB[i][0] = i;
            BB[i][1] = B[i];
        }
        Arrays.sort(A);
        Arrays.sort(
            BB,
            (a, b) -> a[1] - b[1]
        );
        int[] ans = new int[len];
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        for (; i < len && j < len; ++i) {
            if (A[i] > BB[j][1]) {
                ans[BB[j][0]] = A[i];
                ++j;
            } else {
                list.add(A[i]);
            }
        }
        int cnt = 0;
        while (j < len) {
            ans[BB[j][0]] = list.get(cnt);
            ++cnt;
            ++j;
        }
        return ans;
    }
}
// @lc code=end

