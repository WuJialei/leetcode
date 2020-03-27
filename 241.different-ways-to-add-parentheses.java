import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode id=241 lang=java
 *
 * [241] Different Ways to Add Parentheses
 */

// @lc code=start
class Solution {

    List<Integer> ans;
    String pat;
    HashMap<Integer, List<Integer>> map;
    int n;

    public List<Integer> diffWaysToCompute(String input) {
        ans = new ArrayList<Integer>();
        map = new HashMap<>();
        if (input == null || input.length() < 1) {
            return ans;
        }
        pat = input;
        n = input.length()+1;        
        return dfs(0, input.length()-1);
    }

    public List<Integer> dfs (int left, int right) {
        // 剪枝，记忆化搜索
        if (map.containsKey(left*n + right)) {
            return map.get(left*n + right);
        }
        int key = left*n + right;
        List<Integer> value = new ArrayList<>();
        //HashSet<Integer> value = new HashSet<>();
        boolean flag = true;
        // 分解为子问题
        for (int mid = left; mid <= right; ++mid) {
            char c = pat.charAt(mid);
            if (c == '+' || c == '-' || c == '*') {
                if (flag) {
                    flag = false;
                }
                List<Integer> l = dfs(left, mid-1);
                List<Integer> r = dfs(mid+1, right);
                switch (c) {
                    case '+' : 
                        for (int a : l) {
                            for (int b : r) {
                                value.add(a+b);
                            }
                        }
                        break;
                    case '-' :
                        for (int a : l) {
                            for (int b : r) {
                                value.add(a-b);
                            }
                        }
                        break;
                    default:
                        for (int a : l) {
                            for (int b : r) {
                                value.add(a*b);
                            }
                        }
                        break;
                }
            }
        }
        // 子问题出口
        if (flag) {
            value.add(Integer.valueOf(pat.substring(left, right+1)));
        }
        map.put(key, value);
        return value;
    }

}
// @lc code=end

