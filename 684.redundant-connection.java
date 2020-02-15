/*
 * @lc app=leetcode id=684 lang=java
 *
 * [684] Redundant Connection
 */

// @lc code=start
class Solution {

    public class UnionFind{
        int[] parent;
        public UnionFind (int n) {
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        public int find (int index) {
            int x = index;
            while (x != parent[x]) {
                x = parent[x];
            }
            int y = index;
            while (y != parent[y]) {
                int t = parent[y];
                parent[y] = x;
                y = t;
            }
            return x;
        }

        public void union (int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);
            if (aRoot > bRoot) {
                parent[aRoot] = bRoot;
            } else if (aRoot < bRoot) {
                parent[bRoot] = aRoot;
            }
        }

    }

    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length + 5;
        UnionFind uf = new UnionFind(len);
        int[] ans = new int[2];
        for (int i = 0; i < edges.length; ++i) {
            int a = edges[i][0];
            int b = edges[i][1];
            if (uf.find(a) == uf.find(b)) {
                ans[0] = edges[i][0];
                ans[1] = edges[i][1];
            } else {
                uf.union(a, b);
            }
        }
        return ans;
    }


}
// @lc code=end

