import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/*
 * @lc app=leetcode id=851 lang=java
 *
 * [851] Loud and Rich
 */

// @lc code=start
class Solution {

    private ArrayList<Integer>[] lists;
    private int[] quiet;
    private int[] ans;

    public int dfs (int node) {
        if (ans[node] == -1) {
            int min = node;
            for (int next : lists[node]) {
                int tmp = dfs(next);
                if (quiet[tmp] < quiet[min]) {
                    min = tmp;
                }
            }
            ans[node] = min;
        }
        return ans[node];
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        this.quiet = quiet;
        int len = quiet.length;
        lists = new ArrayList[len];
        for (int i = 0; i < len; ++i) {
            lists[i] = new ArrayList<>();
        }
        for (int[] rich : richer) {
            int x = rich[0];
            int y = rich[1];
            lists[y].add(x);
        }
        // dfs(i)返回i的富有者的最安静者
        // 记忆化搜索
        ans = new int[len];
        Arrays.fill(ans, -1);
        for (int i = 0; i < len; ++i) {
            if (ans[i] == -1) {
                dfs(i);
            }
        }
        return ans;
    }
}
// @lc code=end

