import java.util.ArrayList;

class Solution {

    int[][] data;
    int m, n;

    public void sort (int row, int col) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = row, j = col;
        while (i < m && j < n) {
            list.add(data[i][j]);
            ++i;
            ++j;
        }
        Collections.sort(list);
        int cnt  = 0;
        while (cnt < list.size()) {
            data[row++][col++] = list.get(cnt++);
        }
    }

    public int[][] diagonalSort(int[][] mat) {
        data = mat;
        m = mat.length;
        n = mat[0].length;
        for (int row = m - 1; row >= 0; --row) {
            sort(row, 0);
        }
        for (int col = 1; col < n; ++col) {
            sort(0, col);
        }
        return data;
    }
}