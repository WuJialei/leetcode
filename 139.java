class Solution {

    private String s;
    private List<String> wordDict;
    private int[] visited;

    public boolean wordBreak(String s, List<String> wordDict) {
        /*
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 1; i <= n; ++i){
        	for(int j = 0; j < i; ++j){
        		if(dp[j] && wordDict.contains(s.substring(j, i))){
        			dp[i] = true;
        			break;
        		}
        	}
        }
        return dp[n];
        */
        this.s = s;
        this.wordDict = wordDict;
        visited = new int[s.length() + 1];
        return dfs(0, s.length()-1);
    }

    public boolean dfs (int start, int end) {
        if (start > end) {
            visited[start] = 1;
            return true;
        }
        if (visited[start] != 0) {
            return visited[start] == 1 ? true : false;
        }
        for (int i = start; i <= end; ++i) {
            if (wordDict.contains(s.substring(start, i+1)) && dfs(i+1, end)) {
                visited[start] = 1;
                return true;
            } else {
                visited[start] = 2;
            }

        }
        visited[start] = 2;
        return false;
    }

}
