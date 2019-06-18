class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] matrix = new char[n][n];
        List<List<String>> res = new ArrayList<List<String>>();
        for(int i = 0; i < n; ++i){
        	for(int j = 0; j < n; ++j){
        		matrix[i][j] = '.';
        	}
        }
        backTracking(matrix, res, 0, n);
        return res;
    }

    public void backTracking(char[][] map, List<List<String>> response, int index, int nQueen){
    	if(index == nQueen-1){
    		for(int col = 0; col < nQueen; ++col){
    			if(isValid(map, index, col, nQueen)){
	    			map[index][col] = 'Q';
	    			List<String> temp = new ArrayList<String>();
	    			for(int t = 0; t < nQueen; ++t){
	    				temp.add(new String(map[t]));
	    			}
	    			response.add(temp);
	    			map[index][col] = '.';
	    		}
    		}
    		return;
    	}
    	for(int col = 0; col < nQueen; ++col){
    		if(isValid(map, index, col, nQueen)){
    			map[index][col] = 'Q';
    			backTracking(map, response, index+1, nQueen);
    			map[index][col] = '.';
    		}
    	}
    }

    public boolean isValid(char[][] map, int i, int j, int nQueen){
    	boolean flag = true;
    	int up = i - 1;
    	int upLeftx = i - 1;
    	int upLefty = j - 1;
    	int left = j - 1;
    	int upRightx = i - 1;
    	int upRighty = j + 1;
    	while(up >= 0){
    		if(map[up][j] == 'Q'){
    			return false;
    		}
    		--up;
    	}
    	while(left >= 0){
    		if(map[i][left] == 'Q'){
    			return false;
    		}
    		--left;
    	}
    	while(upLeftx >= 0 && upLefty >= 0){
    		if(map[upLeftx][upLefty] == 'Q'){
    			return false;
    		}
    		--upLeftx;
    		--upLefty;
    	}
    	while(upRightx >= 0 && upRighty < nQueen){
    		if(map[upRightx][upRighty] == 'Q'){
    			return false;
    		}
    		--upRightx;
    		++upRighty;
    	}
    	return flag;
    }

}