/*
 * @lc app=leetcode id=959 lang=java
 *
 * [959] Regions Cut By Slashes
 */

// @lc code=start
class Solution {
    public int regionsBySlashes(String[] grid) {
        int len = grid.length;
        UnionFind unionFind = new UnionFind(4*len*len);
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                int index = (i * len + j) * 4;
                switch (grid[i].charAt(j)) {
                    case '/' :
                        unionFind.union(index, index+3);
                        unionFind.union(index+1, index+2);
                        break;
                    case '\\' :
                        unionFind.union(index, index+1);
                        unionFind.union(index+2, index+3);
                        break;
                    case ' ' :
                        unionFind.union(index, index+1);
                        unionFind.union(index+1, index+2);
                        unionFind.union(index+2, index+3);
                        break;
                    default:
                        break;
                }
                if (i < len - 1) {
                    unionFind.union(index+2, index+4*len);
                }
                if (j < len - 1) {
                    unionFind.union(index+1, index+7);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 4*len*len; ++i) {
            if (i == unionFind.find(i)) {
                ++ans;
            }
        }
        return ans;
    }

    public class UnionFind {
        int[] parent;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        public int find (int index) {
            int tmp = index;
            while (index != parent[index]) {
                index = parent[index];
            }
            // 路径压缩
            while (tmp != index) {
                int next = parent[tmp];
                parent[tmp] = index;
                tmp = next;
            } 
            return index;
        }

        public void union(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);
            if (aRoot < bRoot) {
                parent[bRoot] = aRoot;
            } else if (aRoot > bRoot) {
                parent[aRoot] = bRoot;
            }
        }

    }

}
// @lc code=end

