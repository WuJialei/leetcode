class Solution {

	
	private boolean[][] rowUsed = new boolean[9][10];
    private boolean[][] colUsed = new boolean[9][10];
    private boolean[][] cubeUsed = new boolean[9][10];
    //private char[][] board;
    
    public void solveSudoku(char[][] board) {
        //this.board = board;
        for(int i = 0; i < 9; ++i){
        	for(int j = 0; j < 9; ++j){
                if(board[i][j] == '.'){
                    continue;
                }
                rowUsed[i][board[i][j]-'0'] = true;
        		colUsed[j][board[i][j]-'0'] = true;
        		cubeUsed[getCube(i, j)][board[i][j]-'0'] = true;
        	}
        }
        backTracking(0, 0, board);
        
    }

    public boolean backTracking(int row, int col, char[][] board){
    	while(row < 9 && board[row][col] != '.'){
    		row = col==8 ? row + 1 : row;
    		col = col==8 ? 0 : col+1;
    	}
    	if(row == 9){
    		return true;
    	}
    	for(int t = 1; t <= 9; ++t){
    		if(rowUsed[row][t] || colUsed[col][t] || cubeUsed[getCube(row, col)][t]){
    			continue;
    		}
    		rowUsed[row][t] = true;
    		colUsed[col][t] = true;
    		cubeUsed[getCube(row, col)][t] = true;
    		board[row][col] = (char)('0' + t);
    		//backTracking();
    		if(backTracking(row, col, board)){
    			return true;
    		}
    		board[row][col] = '.';
    		rowUsed[row][t] = false;
    		colUsed[col][t] = false;
    		cubeUsed[getCube(row, col)][t] = false;

    	}
    	return false;

    }

    public int getCube(int a, int b){
    	int r = a/3;
    	int c = b/3;
    	return r*3 + c;
    }


}