class Solution {

	private int[][] direaction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int numIslands(char[][] grid) {
        int count = 0;
        if(grid == null || grid.length == 0){
            return 0;
        }
        boolean[][] hasBelonged = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; ++i){
        	for(int j = 0; j < grid[0].length; ++j){
        		if(!hasBelonged[i][j] && grid[i][j] == '1'){
        			dfs(i, j, hasBelonged, grid);
        			++count;
        		}
        	}
        }
        return count;
    }

    public void dfs(int a, int b, boolean[][] belonged, char[][] map){
    	if(a < 0 || a >= map.length || b < 0 || b >= map[0].length){
    		return;
    	}
    	if(!belonged[a][b] && map[a][b] == '1'){
    		belonged[a][b] = true;
    		for(int t = 0; t < direaction.length; ++t){
    			dfs(a + direaction[t][0], b + direaction[t][1], belonged, map);
    		}
    	}
    }
}