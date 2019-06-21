class Solution {
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(k == 0 || n < 1 || n < k){
        	return res;
        }
        List<Integer> item = new ArrayList<Integer>();
        dfs(n, k, 1, res, item);
        return res;
    }

    public void dfs(int nNum, int kNum, int index, List<List<Integer>> result, List<Integer> itemList){
    	if(kNum == 0){
    		result.add(new ArrayList(itemList));
    		return;
    	}
    	for(int i = index; i <= nNum && i + kNum - 1 <= nNum; ++i){
    		itemList.add(i);
    		dfs(nNum, kNum-1, i+1, result, itemList);
    		itemList.remove(itemList.size()-1);
    	}
    }


}