import java.util.List;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(interval);
        }
        Collections.sort(
            list,
            (a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return a[0] - b[0];
                }
            }
        );
        List<int[]> ans = new ArrayList<>();
        int a = list.get(0)[0];
        int b = list.get(0)[1];
        for (int i = 1; i < list.size(); ++i) {
            int c = list.get(i)[0];
            int d = list.get(i)[1];
            if (a == c) {
                b = d;
            } else if (b >= c) {
                b = b < d ? d : b;
            } else {
                ans.add(new int[]{a, b});
                a = c;
                b = d;
            }
        }
        ans.add(new int[]{a, b});
        int[][] ret = new int[ans.size()][2];
        int cnt = 0;
        for (int[] t : ans) {
            ret[cnt][0] = t[0];
            ret[cnt++][1] = t[1];
        }
        return ret;
        
    }
}
// @lc code=end

