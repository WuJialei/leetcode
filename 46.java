class Solution {

	//private List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return res;
        }
        int n = nums.length;
        boolean[] isVisited = new boolean[n];
        List<Integer> item = new ArrayList<Integer>();
        for(int t = 0; t < n; ++t){
            item.add(nums[t]);
            isVisited[t] = true;
            dfs(nums, isVisited, item, 1, res);
            item.remove(Integer.valueOf(nums[t]));
            isVisited[t] = false;
        }
        return res;
    }

    public void dfs(int[] nums, boolean[] visit, List<Integer> itemList, int cnt, List<List<Integer>> result){
        if(cnt == nums.length){
            result.add(new ArrayList(itemList));
            //result.add(itemList);
            return;
        }
        for(int i = 0; i < nums.length; ++i){
            if(!visit[i]){
                itemList.add(nums[i]);
                visit[i] = true;
                dfs(nums, visit, itemList, cnt+1, result);
                itemList.remove(Integer.valueOf(nums[i]));
                visit[i] = false;

            }           
        }
        
    }

}