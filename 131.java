class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(s == null || s.length() == 0){
        	return res;
        }
        List<String> item = new ArrayList<String>();
        dfs(res, item, s);
        return res;
    }

    public void dfs(List<List<String>> result, List<String> itemList, String pat){
    	if(pat.length() == 0){
    		result.add(new ArrayList(itemList));
    		return;
    	}
    	for(int i = 0; i < pat.length(); ++i){
    		if(isPartition(pat, 0, i)){
    			itemList.add(pat.substring(0, i+1));
    			dfs(result, itemList, pat.substring(i+1));
    			itemList.remove(itemList.size()-1);
    		}
    	}
    }

    public boolean isPartition(String temp, int begin, int end){
    	while(begin <= end){
    		if(temp.charAt(begin++) != temp.charAt(end--)){
    			return false;
    		}
    	}
    	return true;
    }


}