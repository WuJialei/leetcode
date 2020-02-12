import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 * @lc app=leetcode id=1042 lang=java
 *
 * [1042] Flower Planting With No Adjacent
 */

// @lc code=start
class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        for (int i = 1; i <= N; ++i) {
            map.put(i, new HashSet<Integer>());
        }
        for (int i = 0; i < paths.length; ++i) {
            int x = paths[i][0];
            int y = paths[i][1];
            map.get(x).add(y);
            map.get(y).add(x);
        }
        int[] ans = new int[N];
        for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
            int key = entry.getKey();
            HashSet<Integer> set = entry.getValue();
            boolean[] visited = new boolean[5];
            for (int point : set) {
                if (ans[point-1] != 0) {
                    visited[ans[point-1]] = true;
                }
            }
            for (int i = 1; i < 5; ++i) {
                if (!visited[i]) {
                    ans[key-1] = i;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

