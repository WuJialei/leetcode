class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0){
        	return res;
        }
        List<Integer> item = new ArrayList<Integer>();
        dfs(candidates, target, 0, item, res);
        return res;
    }


    public void dfs(int[] nums, int sum, int index, List<Integer> temp, List<List<Integer>> result){
    	if(sum == 0){
    		result.add(new ArrayList(temp));
    		return;
    	}
    	for(int i = index; i < nums.length; ++i){
    		if(nums[i] <= sum){
    			temp.add(nums[i]);
    			dfs(nums, sum-nums[i], i, temp, result);
    			temp.remove(temp.size()-1);
    		}
    	}
    }

}