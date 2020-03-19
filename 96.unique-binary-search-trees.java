/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
class Solution {

    boolean[] flags;

    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        /*
        G(n): 长度为n的序列的不同二叉搜索树个数。
        F(i,n): 以i为根的不同二叉搜索树个数。
        链接：https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode/
        */
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
        /*
        flags = new boolean[n+1];
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            flags[i] = true;
            ans += dfs(i, 1, n);
            flags[i] = false;
        }
        return ans;
        */
    }

    public int dfs (int index, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return 1;
        }
        int left = 0;
        for (int next = start; next < index; ++next) {
            if (!flags[next]) {
                flags[next] = true;
                left += dfs(next, start, index-1);
                flags[next] = false;
            }
        }
        int right = 0;
        for (int next = index+1; next <= end; ++next) {
            if (!flags[next]) {
                flags[next] = true;
                right += dfs(next, index+1, end);
                flags[next] = false;
            }
        }
        return (left == 0 || right == 0) ? Math.max(left, right) : left * right;
    }


}
// @lc code=end

