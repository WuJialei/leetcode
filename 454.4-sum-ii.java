import java.util.HashMap;

/*
 * @lc app=leetcode id=454 lang=java
 *
 * [454] 4Sum II
 */

// @lc code=start
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || A.length < 1) {
            return 0;
        }
        int len = A.length;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        // HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                map1.put(A[i] + B[j], map1.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                if (map1.containsKey(-(C[i] + D[j]))) {
                    ans += map1.get(-(C[i] + D[j]));
                }
                // map2.put(C[i] + D[j], map2.getOrDefault(C[i] + D[j], 0) + 1);
            }
        }
        // int ans = 0;
        // for (int key1 : map1.keySet()) {
        //     if (map2.containsKey(-key1)) {
        //         ans += map1.get(key1) * map2.get(-key1);
        //     }
        // }
        return ans;
    }
}
// @lc code=end

