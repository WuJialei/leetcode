import java.util.ArrayList;
import java.util.List;

class Solution {

	private List<List<String>> ans;
	private String s;

    public List<List<String>> partition(String s) {
		this.s = s;
		ans = new ArrayList<List<String>>();
		List<String> ansItem = new ArrayList<String>();
		dfs(ansItem, 0);
		return ans;
		/*
        List<List<String>> res = new ArrayList<List<String>>();
        if(s == null || s.length() == 0){
        	return res;
        }
        List<String> item = new ArrayList<String>();
        dfs(res, item, s);
		return res;
		*/
    }

	public void dfs(List<String> item, int start) {
		if (start == s.length()) {
			ans.add(new ArrayList(item));
			return;
		}
		for (int i = start; i < s.length(); ++i) {
			if (isPartion(start, i)) {
				item.add(s.substring(start, i+1));
				dfs(item, i+1);
				item.remove(item.size()-1);
			}
		}
	}

	public boolean isPartion(int begin, int end) {
		while(begin < end) {
			if(s.charAt(begin++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}


	/*
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
	*/


}
