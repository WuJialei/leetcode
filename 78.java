/*
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	//res.add(new ArrayList<Integer>());
        if(nums == null || nums.length == 0){
        	return res;
        }
        List<Integer> item = new ArrayList<Integer>();
        dfs(nums, item, 0, res);
        return res;
    }

    public void dfs(int[] numbers, List<Integer> itemList, int index, List<List<Integer>> result){
    	if(index == numbers.length ){
            if(!result.contains(itemList)){
                result.add(new ArrayList(itemList));
            }
    		return;
    	}
    	for(int i = index; i < numbers.length; ++i){
            if(!result.contains(itemList)){
                result.add(new ArrayList(itemList));
            }
    		
    		itemList.add(numbers[i]);
    		dfs(numbers, itemList, i+1, result);
    		itemList.remove(itemList.size()-1);
    	}
    }

}
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	//res.add(new ArrayList<Integer>());
        if(nums == null || nums.length == 0){
        	return res;
        }
        List<Integer> item = new ArrayList<Integer>();
        for(int i = 0; i <= nums.length; ++i){
        	dfs(nums, item, 0, i, res);
        }
        
        return res;
    }

    public void dfs(int[] numbers, List<Integer> itemList, int index, int size, List<List<Integer>> result){
    	if(itemList.size() == size ){
            result.add(new ArrayList(itemList));
    		return;
    	}
    	for(int i = index; i < numbers.length; ++i){
    		itemList.add(numbers[i]);
    		dfs(numbers, itemList, i+1, size, result);
    		itemList.remove(itemList.size()-1);
    	}
    }

}