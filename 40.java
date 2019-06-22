class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0){
        	return res;
        }
        Arrays.sort(candidates);
        List<Integer> item = new ArrayList<Integer>();
        boolean[] isVisited = new boolean[candidates.length];
        dfs(candidates, target, 0, item, res, isVisited);
        return res;        
    }

    public void dfs(int[] nums, int sum, int index, List<Integer> temp, List<List<Integer>> result, boolean[] visit){
    	if(sum == 0){
    		result.add(new ArrayList(temp));
    		return;
    	}
    	for(int i = index; i < nums.length; ++i){
    		if(visit[i]){
    			continue;
    		}
    		if(i > 0 && nums[i] == nums[i-1] && !visit[i-1]){
    			continue;
    		}
    		if(nums[i] <= sum){
    			temp.add(nums[i]);
    			visit[i] = true;
    			dfs(nums, sum-nums[i], i+1, temp, result, visit);
    			temp.remove(temp.size()-1);
    			visit[i] = false;
    		}
    	}
    }
}