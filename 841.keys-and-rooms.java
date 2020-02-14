import java.util.List;

/*
 * @lc app=leetcode id=841 lang=java
 *
 * [841] Keys and Rooms
 */

// @lc code=start
class Solution {

    List<Integer> ans;
    List<List<Integer>> graph;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        graph = rooms;
        ans = new ArrayList<Integer>();
        int n = rooms.size();
        ans.add(0);
        dfs(0);
        return ans.size() == n;
    }

    public void dfs (int index) {
        for (int next : graph.get(index)) {
            if (!ans.contains(next)) {
                ans.add(next);
                dfs(next);
            }
        }
    }

}
// @lc code=end

