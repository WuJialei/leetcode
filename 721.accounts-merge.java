import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/*
 * @lc app=leetcode id=721 lang=java
 *
 * [721] Accounts Merge
 */

// @lc code=start
class Solution {

    private UnionFind uf;

    public class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        public int find(int index) {
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

        public void union(int a, int b) {
            int aa = find(a);
            int bb = find(b);
            if (aa > bb) {
                parent[aa] = bb;
            } else if (aa < bb) {
                parent[bb] = aa;
            }
        }

    }


    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        if (accounts == null || accounts.size() < 1) {
            return ans;
        }
        int len = accounts.size();
        // 建立每个用户邮箱到accounts遍历id的HashMap和并查集确立遍历id间的关系
        uf = new UnionFind(len);
        HashMap<String, Integer> email2id = new HashMap<>();
        for (int i = 0; i < accounts.size(); ++i) {
            for (int j = 1; j < accounts.get(i).size(); ++j) {
                if (email2id.containsKey(accounts.get(i).get(j))) {
                    uf.union(email2id.get(accounts.get(i).get(j)), i);
                } else {
                    email2id.put(accounts.get(i).get(j), i);
                }
            }
        }
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; ++i) {
            if (!visited[i]) {                
                int index = i;
                HashSet<String> set = new HashSet<>();
                for (int j = i; j < len; ++j) {
                    if (index == uf.find(j) && !visited[j]) {
                        visited[j] = true;
                        for (int k = 1; k < accounts.get(j).size(); ++k) {
                            set.add(accounts.get(j).get(k));
                        }
                    }                    
                }
                ArrayList<String> list = new ArrayList<>();
                for (String str : set) {
                    list.add(str);
                }
                Collections.sort(list);
                list.add(0, accounts.get(i).get(0));
                ans.add(list);
            }
        }
        return ans;    

    }
}
// @lc code=end

