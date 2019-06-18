class Solution {

	private static final String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits == null || digits.length() == 0){
        	return res;
        }
        dfs("", digits, 0, res);
        return res;
    }

    public void dfs(String pre, String dig, int offet, List<String> response){
    	if(offet == dig.length()){
    		response.add(pre);
    		return;
    	}
    	String temp = keys[dig.charAt(offet) - '0'];
    	for(char a : temp.toCharArray()){
    		dfs(pre + a, dig, offet+1, response);
    	}
    }
}