/*
 * @lc app=leetcode id=529 lang=java
 *
 * [529] Minesweeper
 */

// @lc code=start
class Solution {

    private char[][] ans;
    private int row;
    private int col;
    private int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public int judge (int a, int b) {
        int num = 0;
        for (int i = 0; i < dx.length; ++i) {
            int aa = a + dx[i];
            int bb = b + dy[i];
            if (aa < 0 || aa >= row || bb < 0 || bb >= col) {
                continue;
            }
            if (ans[aa][bb] == 'M') {
                ++num;
            }
        }
        return num;
    }

    public void dfs (int x, int y) {
        if (x < 0 || x >= row || y < 0 || y >= col) {
            return;
        }
        // 判断为E或者M包含了去除已搜索的情况
        if (ans[x][y] == 'E') {
            ans[x][y] = 'B';
            int cnt = judge(x, y);
            if (cnt > 0) {
                ans[x][y] = (char)('0' + cnt);
            } else {
                // 为B才能递归
                for (int i = 0; i < dx.length; ++i) {
                    dfs(x + dx[i], y + dy[i]);
                }
            }
            
        } else if (ans[x][y] == 'M') {
            ans[x][y] = 'X';
        }
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        ans = board;
        row = board.length;
        col = board[0].length;
        dfs(click[0], click[1]);
        return ans;
    }
}
// @lc code=end

