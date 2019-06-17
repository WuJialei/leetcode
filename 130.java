class Solution {

	private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void solve(char[][] board) {
        if(board == null || board.length == 0){
        	return;
        }
        int m = board.length;
        int n = board[0].length;
        // boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; ++i){
        	//dfs(board, visited, i, 0);
            dfs(board, i, 0);
        	//dfs(board, visited ,i, n-1);
            dfs(board, i, n-1);
        }
        for(int j = 0; j < n; ++j){
        	//dfs(board, visited, 0, j);
            dfs(board, 0, j);
        	//dfs(board, visited, m-1, j);
            dfs(board, m-1, j);
        }
        for(int a = 0; a < m; ++a){
        	for(int b = 0; b < n; ++b){
        		if(board[a][b] == 'T'){
        			board[a][b] = 'O';
        		}
        		else if(board[a][b] == 'O'){
        			board[a][b] = 'X';
        		}
        		else{
        			
        		}
        	}
        }

    }

    public void dfs(char[][] temp, int r, int c){
    	if(r < 0 || r >= temp.length || c < 0 || c >= temp[0].length || temp[r][c] == 'X' || temp[r][c] == 'T'){
    		return;
    	}
    	//flag[r][c] = true;
    	temp[r][c] = 'T';
    	for(int k = 0; k < direction.length; ++k){
    		dfs(temp, r + direction[k][0], c + direction[k][1]);
    	}
    }
}