/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {

    int[] visited;
    int[][] graph;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        graph = new int[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; ++i) {
            int x = prerequisites[i][0];
            int y = prerequisites[i][1];
            graph[x][y] = 1;
        }
        for (int i = 0; i < numCourses; ++i) {
            if (visited[i] == 0 && !dfs(i, numCourses)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs (int index, int n) {
        visited[index] = 1;
        for (int j = 0; j < n; ++j) {
            if (graph[index][j] > 0) {
                if (visited[j] == 1) {
                    return false;
                } else if (visited[j] == 0) {
                    if(!dfs(j, n)){
                        return false;
                    }
                }
            }
        }
        visited[index] = 2;
        return true;
    }

}
// @lc code=end

