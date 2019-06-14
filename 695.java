class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        for(int i = 0; i < m; ++i){
        	for(int j = 0; j < n; ++j){
        		maxArea = Math.max(maxArea, dfs(grid, i, j));
        	}
        }
        return maxArea;
    }

    public int dfs(int[][] temp, int a, int b){
    	int m1 = temp.length;
    	int n1 = temp[0].length;
    	if(a < 0 || a >= m1 || b < 0 || b >= n1){
    		return 0;
    	}
    	if(temp[a][b] == 0){
    		return 0;
    	}
    	temp[a][b] = 0;
    	int count =  dfs(temp, a - 1, b) + dfs(temp, a + 1, b) + dfs(temp, a, b - 1) + dfs(temp, a, b + 1);
    	++count;
    	return count;
    }
}