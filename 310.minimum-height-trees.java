import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=310 lang=java
 *
 * [310] Minimum Height Trees
 */

// @lc code=start
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> ret = new ArrayList<>();
            ret.add(0);
            return ret;
        }
        HashSet<Integer>[] graph = new HashSet[n];
        for (int i = 0; i < n; ++i) {
            graph[i] = new HashSet<>();
        }
        int[] degree = new int[n];
        for (int i = 0; i < edges.length; ++i) {
            int x = edges[i][0];
            int y = edges[i][1];
            ++degree[x];
            ++degree[y];
            graph[x].add(y);
            graph[y].add(x);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        int cnt = n;
        while (cnt != 1 && cnt != 2) {
            int len = queue.size();
            cnt -= len;
            while (len > 0) {
                int cur = queue.poll();
                for (int nei : graph[cur]) {
                    --degree[nei];
                    if (degree[nei] == 1) {
                        queue.offer(nei);
                    }
                }
                --len;
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            ans.add(queue.poll());
        }
        return ans;
        /*
        int[] ans = new int[n];
        int minVal = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            int cnt = 0;
            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            visited[i] = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                ++cnt;
                while (size > 0) {
                    int cur  = queue.poll();
                    for (int next : graph[cur]) {
                        if (!visited[next]) {
                            queue.offer(next);
                            visited[next] = true;;
                        }
                    }
                    --size;
                }
            }
            ans[i] = cnt;
            minVal = Math.min(minVal, cnt);
        }

        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (ans[i] == minVal) {
                ret.add(i);
            }
        }
        return ret;
        */
    }
}
// @lc code=end

