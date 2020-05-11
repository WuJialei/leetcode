import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=1376 lang=java
 *
 * [1376] Time Needed to Inform All Employees
 */

// @lc code=start
class Solution {

    private int ans;
    private HashMap<Integer, ArrayList<Integer>> map;
    private int[] informTime;


    public void dfs (int cur, int cnt) {
        if (!map.containsKey(cur)) {
            ans = Math.max(ans, cnt);
            return;
        }
        for (int next : map.get(cur)) {
            dfs(next, cnt + informTime[cur]);
        }
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (n < 2) {
            return 0;
        }
        map = new HashMap<>();
        for (int i = 0; i < manager.length; ++i) {
            if (manager[i] == -1) {
                continue;
            }
            if (!map.containsKey(manager[i])) {
                map.put(manager[i], new ArrayList<>());
            }
            map.get(manager[i]).add(i);
        }
        ans = 0;
        this.informTime = informTime;
        dfs(headID, 0);
        return ans;
    }
}
// @lc code=end

