import java.util.HashSet;

/*
 * @lc app=leetcode id=947 lang=java
 *
 * [947] Most Stones Removed with Same Row or Column
 */

// @lc code=start
class Solution {

    public class UnionFind {

        private int[] parent;

        public UnionFind (int cnt) {
            parent = new int[cnt];
            for (int i = 0; i < cnt; ++i) {
                parent[i] = i;
            }
        }

        public int find (int index) {
            int tmp = index;
            while (index != parent[index]) {
                index = parent[index];
            }
            while (parent[tmp] != index) {
                int next = parent[tmp];
                parent[tmp] = index;
                tmp = next;
            }
            return index;
        }

        public void union (int a, int b) {
            int aa = find(a);
            int bb = find(b);
            if (aa > bb) {
                parent[aa] = bb;
            } else if (aa < bb) {
                parent[bb] = aa;
            }
        }

    }

    public int removeStones(int[][] stones) {
        if (stones == null || stones.length < 1 || stones[0].length < 1) {
            return 0;
        }
        // 节点只有在同一行或者同一列存在另一节点的时候才能被移动
        // 按照同行或同列要求建立连通图，一个连通图内的移动次数是连通图内的边数（即：节点数-1）
        // 图内的移动次数：所有节点数-连通图个数
        //
        UnionFind uf = new UnionFind(20005);
        for (int[] stone : stones) {
            uf.union(stone[0], stone[1] + 10000);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int[] stone : stones) {
            set.add(uf.find(stone[0]));
        }
        return stones.length - set.size();
    }
}
// @lc code=end

