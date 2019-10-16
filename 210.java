import java.util.ArrayList;

class Solution {

    private int[] ret;
    private int start;

    public boolean dfs (int index, HashSet<Integer>[] graph, int[] visited) {
        if (visited[index] == 1) {
            return true;
        }
        if (visited[index] == 2) {
            return false;
        }
        visited[index] = 1;
        for (int neighbor : graph[index]) {
            if (dfs(neighbor, graph, visited)) {
                return true;
            }
        }
        visited[index] = 2;
        ret[start++] = index;
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ret = new int[numCourses];
        start = 0;
        if (numCourses <= 0) {
            return new int[0];
        }
        HashSet<Integer>[] graph = new HashSet[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            graph[i] = new HashSet<Integer>();
        }
        int len = prerequisites.length;
        for (int i = 0; i < len; ++i) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            if (dfs(i, graph, visited)) {
                return new int[0];
            }
        }
        return ret;
    }
}