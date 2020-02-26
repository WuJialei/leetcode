/*
 * @lc app=leetcode id=1030 lang=java
 *
 * [1030] Matrix Cells in Distance Order
 */

// @lc code=start
class Solution {

    int x0, y0;

    public class Cell {
        int x, y;

        public Cell(int a, int b) {
            x = a;
            y = b;
        }

        public int dis() {
            return Math.abs(x0-x) + Math.abs(y0-y);
        }

    }

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        x0 = r0;
        y0 = c0;
        List<Cell> list = new ArrayList<>();
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                list.add(new Cell(i, j));
            }
        }
        Collections.sort(list, (a, b) -> a.dis() - b.dis());
        int[][] ans = new int[R*C][2];
        int cnt = 0;
        for (Cell cell : list) {
            ans[cnt][0] = cell.x;
            ans[cnt][1] = cell.y;
            ++cnt;
        }
        return ans;
    }
}
// @lc code=end

