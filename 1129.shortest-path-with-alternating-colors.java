import java.util.Queue;

/*
 * @lc app=leetcode id=1129 lang=java
 *
 * [1129] Shortest Path with Alternating Colors
 */

// @lc code=start
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        // 2*n数组，每个数组元素的set，防止平行边和自环，2代表2种颜色，n代表每个点，set里面为该点可到达的其他点
        HashSet<Integer>[][] graph = new HashSet[2][n];
        // steps表示最后一段距离为该种颜色的红蓝两边到达的最短步数
        int[][] steps = new int[2][n];

        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < n; ++j) {
                graph[i][j] = new HashSet<Integer>();
                steps[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int[] red : red_edges) {
            graph[0][red[0]].add(red[1]);
        }

        for (int[] blue : blue_edges) {
            graph[1][blue[0]].add(blue[1]);
        }

        steps[0][0] = 0;
        steps[1][0] = 0;

        // 队列，使用bfs，一层一层扩大找路径步数
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{1, 0});
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int color = tmp[0];
            int point = tmp[1];
            for (int next : graph[color][point]) {
                if (steps[1-color][next] == Integer.MAX_VALUE) {
                    steps[1-color][next] = steps[color][point] + 1;
                    queue.offer(new int[]{1-color, next});
                }
            }

        }
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = Math.min(steps[0][i], steps[1][i]) == Integer.MAX_VALUE ? -1 : Math.min(steps[0][i], steps[1][i]);
        }
        return ans;

    }
}
// @lc code=end

