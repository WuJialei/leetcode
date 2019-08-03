class Solution {
	private int cnt = 0;

    public int countSubstrings(String s) {
        if(s == null || s.length() == 0){
        	return 0;
        }
        for (int i = 0; i < s.length() ; ++i) {
        	getSubStrings(s, i, i);
        	getSubStrings(s, i, i+1);
        }
        return cnt;
    }

    public void getSubStrings(String pat, int start, int end){
    	while(start >= 0 && end < pat.length() && pat.charAt(start) == pat.charAt(end)){
    		--start;
    		++end;
    		++cnt;
    	}
    }

}