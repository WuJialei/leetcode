class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
        	List<Integer> temp = new ArrayList<Integer>();
        	res.add(new ArrayList(temp));
        	return res;
        }
        Arrays.sort(nums);
        boolean[] isVisited = new boolean[nums.length];
        List<Integer> item = new ArrayList<Integer>();
        for(int cnt = 0; cnt <= nums.length; ++cnt){
        	dfs(nums, cnt, 0, res, isVisited, item);
        }
        return res;

    }

    public void dfs(int[] numbers, int size, int index, List<List<Integer>> result, boolean[] visit, List<Integer> itemList){
    	if(itemList.size() == size){
    		result.add(new ArrayList(itemList));
    		return;
    	}
    	for(int i = index; i < numbers.length; ++i){
    		if(visit[i]){
    			continue;
    		}
    		if(i > 0 && numbers[i] == numbers[i-1] && !visit[i-1]){
    			continue;
    		}
    		visit[i] = true;
    		itemList.add(numbers[i]);
    		dfs(numbers, size, i+1, result, visit, itemList);
    		itemList.remove(itemList.size()-1);
    		visit[i] = false;
    	}
    }


}