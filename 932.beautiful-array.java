import java.util.HashMap;

/*
 * @lc app=leetcode id=932 lang=java
 *
 * [932] Beautiful Array
 */

// @lc code=start
class Solution {

    HashMap<Integer, int[]> map;

    public int[] beautifulArray(int N) {
        map = new HashMap<>();
        return dfs(N);
    }

    public int[] dfs (int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 1) {
            return new int[]{1};
        }
        int[] ans = new int[n];
        int cnt = 0;
        // dfs(n) 表示是1->n的最美数组，左面是奇数，右面是偶数，i在奇数，j在偶数，k在i和j之间所以此时肯定是最美数组
        // 所以需要保证在奇数数组、偶数数组里也是最美数组，分割为两个子问题
        for (int left : dfs((n+1)/2)) {
            ans[cnt++] = 2 * left - 1;
        }
        for (int right : dfs(n/2)) {
            ans[cnt++] = 2 * right;
        }
        return ans;
    }

}
// @lc code=end

