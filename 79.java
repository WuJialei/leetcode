class Solution {

	private int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0){
        	return true;
        }
        if(board == null || board.length == 0){
        	return false;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] isVisited = new boolean[m][n];
        for(int i = 0; i < m; ++i){
        	for(int j = 0; j < n; ++j){
        		if(dfs(board, word, 0, i, j, isVisited)){
        			return true;
        		}
        	}
        }
        return false;
    }

    public boolean dfs(char[][] temp, String pattern, int index, int r, int c, boolean[][] visit){
    	if(index == pattern.length()){
    		return true;
    	}
    	if(r < 0 || r >= temp.length || c < 0 || c >= temp[0].length || visit[r][c] || temp[r][c] != pattern.charAt(index)){
    		return false;
    	}
    	visit[r][c] = true;
    	for(int t = 0; t < direction.length; ++t){
    		int rTemp = r + direction[t][0];
    		int cTemp = c + direction[t][1];
    		if(dfs(temp, pattern, index+1, rTemp, cTemp, visit)){
    			return true;
    		}
    	}
    	visit[r][c] = false;
    	return false;
    }


}