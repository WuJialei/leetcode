import java.util.HashMap;

/*
 * @lc app=leetcode id=990 lang=java
 *
 * [990] Satisfiability of Equality Equations
 */

// @lc code=start
class Solution {

    public class UnionFind {
        int[] parent;
        public UnionFind (int len) {
            parent = new int[len];
            for (int i = 0; i < len; ++i) {
                parent[i] = i;
            }
        }

        public int find (int index) {
            int x = index;
            while (x != parent[x]) {
                x = parent[x];
            }
            int y = index;
            while (parent[y] != x) {
                int next = parent[y];
                parent[y] = x;
                y = next;
            }
            return x;
        }

        public void union (int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);
            if (aRoot < bRoot) {
                parent[bRoot] = aRoot;
            } else if (aRoot > bRoot) {
                parent[aRoot] = bRoot;
            }
        }

    }

    public boolean equationsPossible(String[] equations) {
        UnionFind uf  = new UnionFind(26);
        for (String str : equations) {
            if (str.charAt(1) == '='){
                uf.union(str.charAt(0) - 'a', str.charAt(3) - 'a');
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!'){
                if (uf.find(str.charAt(0) - 'a') == uf.find(str.charAt(3) - 'a')) {
                    return false;
                }   
            }
        }
        return true;
    }
}
// @lc code=end

