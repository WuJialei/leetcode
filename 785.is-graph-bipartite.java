/*
 * @lc app=leetcode id=785 lang=java
 *
 * [785] Is Graph Bipartite?
 */

// @lc code=start
class Solution {

    int[][] g;
    int[] color;

    public boolean isBipartite(int[][] graph) {
        g = graph;
        int len = graph.length;
        color = new int[len];
        for (int i = 0; i < len; ++i) {
            if (color[i] == 0) {
                if (!dfs(i, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs (int index, int c) {
        color[index] = c;
        for (int j = 0; j < g[index].length; ++j) {
            if (color[g[index][j]] == 0) {
                if (!dfs(g[index][j], -c)) {
                    return false;
                }
            } else if (color[g[index][j]] == c) {
                return false;
            }
        }
        return true;
    }

}
// @lc code=end

