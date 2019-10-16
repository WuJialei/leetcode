class Solution {

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
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }
        HashSet<Integer>[] graph = new HashSet[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            graph[i] = new HashSet<Integer>();
        }
        int len = prerequisites.length;
        for (int i = 0; i < len; ++i) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            if (dfs(i, graph, visited)) {
                return false;
            }
        }
        return true;
    }
}