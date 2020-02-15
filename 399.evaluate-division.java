import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode id=399 lang=java
 *
 * [399] Evaluate Division
 */

// @lc code=start
class Solution {

    HashMap<String, HashMap<String, Double>> map;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        map = new HashMap<>();
        for (int i = 0; i < equations.size(); ++i) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];
            if (!map.containsKey(a)) {
                map.put(a, new HashMap<String, Double>());
            }
            if (!map.containsKey(b)) {
                map.put(b, new HashMap<String, Double>());
            }
            map.get(a).put(b, val);
            map.get(b).put(a, 1.0 / val);
        }
        int n = queries.size();
        double[] ans = new double[n];
        for (int i = 0; i < n; ++i) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if (!map.containsKey(a) || !map.containsKey(b)) {
                ans[i] = -1.0;
                continue;
            }
            ans[i] = dfs(a, b, new HashSet<String>());

        }
        return ans;
    }

    public double dfs (String src, String dst, HashSet<String> set) {
        if (src.equals(dst)) {
            return 1.0;
        }
        if (!map.containsKey(src)) {
            return -1.0;
        }
        set.add(src);
        for (String next : map.get(src).keySet()) {
            if (!set.contains(next)) {
                set.add(next);
                double t = dfs(next, dst, set);
                if (t > 0) {
                    double cur = map.get(src).get(next);
                    return cur * t;
                }
            }
            
        }
        return -1.0;
    }

}
// @lc code=end

