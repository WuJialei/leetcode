class Solution {

	private int cnt = 0;

    public int countBinarySubstrings(String s) {
        if(s == null || s.length() < 2){
        	return 0;
        }
        for(int i = 0; i < s.length() - 1; ++i){
        	if(s.charAt(i) != s.charAt(i+1)){
        		++cnt;
        		getBinarySubString(s, i-1, i+2);
        	}        	
        }
        return cnt;
    }

    public void getBinarySubString(String pat, int start, int end){
    	while(start >= 0 && end < pat.length() && (pat.charAt(start) == pat.charAt(start+1)) && (pat.charAt(end) == pat.charAt(end-1))){
    		--start;
    		++end;
    		++cnt;
    	}
    }

}