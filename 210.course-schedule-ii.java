import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Iterator;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {

    int[] visited;
    HashMap<Integer, List<Integer>> graph;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        graph = new HashMap<>();
        for (int i = 0; i < numCourses; ++i) {
            graph.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; ++i) {
            int x = prerequisites[i][0];
            int y = prerequisites[i][1];
            graph.get(y).add(x);
        }
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (dfs(i, stack)) {
                return new int[0];
            }
        }
        int[] ans = new int[numCourses];
        int k = 0;
        while (!stack.isEmpty()) {
            ans[k++] = stack.pop();
        }
        return ans;
    }

    public boolean dfs (int index, Stack<Integer> s) {
        if (visited[index] == 1) {
            return true;
        }
        if (visited[index] == 2) {
            return false;
        }
        visited[index] = 1;
        for (int j = 0; j < graph.get(index).size(); ++j) {
            if (dfs(graph.get(index).get(j), s)) {
                return true;
            }
        }
        s.push(index);
        visited[index] = 2;
        return false;
    }

}
// @lc code=end

