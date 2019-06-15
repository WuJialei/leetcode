class Solution {
    public int findCircleNum(int[][] M) {
        int count = 0;
        int m = M.length;
        boolean[] visited = new boolean[m];
        for(int i = 0; i < m; ++i){
        	if(!visited[i]){
        		visited[i] = true;
        		dfs(visited, i, M);
        		++count;
        	}
        }
        return count;
    }

    public void dfs(boolean[] temp, int location, int[][] map){
    	for(int j = 0; j < map.length; ++j){
    		if(map[location][j] == 1 && !temp[j]){
    			temp[j] = true;
    			dfs(temp, j, map);
    		}
    	}
    }
}