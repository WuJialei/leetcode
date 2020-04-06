import java.util.Arrays;

/*
 * @lc app=leetcode id=1090 lang=java
 *
 * [1090] Largest Values From Labels
 */

// @lc code=start
class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int n = values.length;
        int[][] arrays = new int[n][2];
        int[] cnt = new int[20005];
        for (int i = 0; i < n; ++i) {
            arrays[i][0] = values[i];
            arrays[i][1] = labels[i];
        }
        Arrays.sort(
            arrays,
            (a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return b[0] - a[0];
                }
            }
        );
        int ans = 0;
        int cur = 0;
        while (cur < n && num_wanted > 0) {
            if (cnt[arrays[cur][1]] < use_limit) {
                ans += arrays[cur][0];
                ++cnt[arrays[cur][1]];
                --num_wanted;
            }
            ++cur;
        }
        return ans;
    }
}
// @lc code=end

