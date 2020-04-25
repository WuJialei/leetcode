class Solution {
    
    public class UnionFind {
        
        int[] parent;
        
        public UnionFind (int n) {
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }
        
        public int find (int x) {
            int temp = x;
            while (x != parent[x]) {
                x = parent[x];
            }
            while (parent[temp] != x) {
                int next = parent[temp];
                parent[temp] = x;
                temp = next;
            }
            return x;
        }
        
        public void union(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);
            if (aRoot > bRoot) {
                parent[aRoot] = bRoot;
            } else if (aRoot < bRoot) {
                parent[bRoot] = aRoot;
            }
        }
        
    }
    
    public int makeConnected(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n);
        // 多余的边个数
        int cnt = 0;
        for (int[] conn : connections) {
            int a = conn[0];
            int b = conn[1];
            if (uf.find(a) == uf.find(b)) {
                ++cnt;
            } else {
                uf.union(a, b);
            }
        }
        // 连通分量的个数
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            set.add(uf.find(i));
        }
        int num = set.size() - 1;
        return cnt >= num ? num : -1;
        
    }
}