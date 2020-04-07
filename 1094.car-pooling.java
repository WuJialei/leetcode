/*
 * @lc app=leetcode id=1094 lang=java
 *
 * [1094] Car Pooling
 */

// @lc code=start
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // 差分+前缀和解决某个区间内加固定值问题
        int[] cnt = new int[1005];
        for (int[] trip : trips) {
            cnt[trip[1]] += trip[0];
            cnt[trip[2]] -= trip[0];
        }
        if (cnt[0] > capacity) {
            return false;
        }
        for (int i = 1; i <= 1000; ++i) {
            cnt[i] += cnt[i-1];
            if (cnt[i] > capacity) {
                return false;
            }
        }
        return true;
        // int[] cnt = new int[1005];
        // for (int[] trip : trips) {
        //     int num = trip[0];
        //     int begin = trip[1];
        //     int end = trip[2];
        //     for (int i = begin; i < end; ++i) {
        //         cnt[i] += num;
        //         if (cnt[i] > capacity) {
        //             return false;
        //         }
        //     }
        // }
        // return true;
    }
}
// @lc code=end

