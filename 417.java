class Solution {

	private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<int[]>();
        if(matrix == null || matrix.length == 0){
        	return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] visPac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];
        boolean[][] visAtl = new boolean[m][n];
        for(int i = 0; i < m; ++i){
        	pac[i][0] = true;
        	atl[i][n-1] = true;
        }
        for(int j = 0; j < n; ++j){
        	pac[0][j] = true;
        	atl[m-1][j] = true;
        }
        for(int i = 0; i < m; ++i){
        	dfs(matrix, pac, i, 0, visPac);
        	dfs(matrix, atl, i, n-1, visAtl);
        }
        for(int j = 0; j < n; ++j){
        	dfs(matrix, pac, 0, j, visPac);
        	dfs(matrix, atl, m-1, j, visAtl);
        }
        for(int a = 0; a < m; ++a){
        	for(int b = 0; b < n; ++b){
        		if(pac[a][b] && atl[a][b]){
        			//int[] arrayTemp = {a, b};
        			res.add(new int[]{a, b});
        		}
        	}
        }
        return res;
    }

    public boolean judge(int[][] temp, int r, int c){
    	if(r < 0 || r >= temp.length || c < 0 || c >= temp[0].length){
    		return false;
    	}
    	else{
    		return true;
    	}
    }

    public void dfs(int[][] temp, boolean[][] flag, int r, int c, boolean[][] visited){
    	if(r < 0 || r >= temp.length || c < 0 || c >= temp[0].length || visited[r][c]){
    		return;
    	}
    	visited[r][c] = true;
        flag[r][c] = true;
    	for(int k = 0; k < direction.length; ++k){
    		int rTemp = r + direction[k][0];
    		int cTemp = c + direction[k][1];
    		boolean flagTemp = judge(temp, rTemp, cTemp);
    		if(flagTemp && temp[r][c] <= temp[rTemp][cTemp]){    			
    			dfs(temp, flag, rTemp, cTemp, visited);
    		}
    	}

    }
}