/*
class Solution {

	//private List<List<Integer>> res = new ArrayList<List<Integer>>();

    class Solution {

        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if(nums == null || nums.length == 0){
                return res;
            }
            int n = nums.length;
            //Arrays.sort(nums);
            boolean[] isVisited = new boolean[n];
            List<Integer> item = new ArrayList<Integer>();
            dfs(nums, isVisited, item, res);
            return res;
        }

        public void dfs(int[] nums, boolean[] visit, List<Integer> itemList, List<List<Integer>> result){
            if(itemList.size() == nums.length){
                List<Integer> temp = new ArrayList(itemList);
                if(!result.contains(temp)){
                    result.add(temp);
                }
                return;
            }
            for(int i = 0; i < nums.length; ++i){
                if(visit[i]){
                    continue;
                }
                itemList.add(nums[i]);
                visit[i] = true;
                dfs(nums, visit, itemList, result);
                itemList.remove(itemList.size()-1);
                // 不可以按照数值删除 因为有重复
                visit[i] = false;
            }
            
        }

    }

}
*/

class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return res;
        }
        int n = nums.length;
        Arrays.sort(nums);
        boolean[] isVisited = new boolean[n];
        List<Integer> item = new ArrayList<Integer>();
        dfs(nums, isVisited, item, res);
        return res;
    }

    public void dfs(int[] nums, boolean[] visit, List<Integer> itemList, List<List<Integer>> result){
        if(itemList.size() == nums.length){
            List<Integer> temp = new ArrayList(itemList);
            /*
            if(!result.contains(temp)){
                result.add(temp);
            }
            */
            result.add(temp);
            return;
        }
        for(int i = 0; i < nums.length; ++i){
            if(visit[i]){
                continue;
            }
            if(i >= 1 && nums[i] == nums[i-1] && !visit[i-1]){
                continue;
            }
            itemList.add(nums[i]);
            visit[i] = true;
            dfs(nums, visit, itemList, result);
            itemList.remove(itemList.size()-1);
            // 不可以按照数值删除 因为有重复
            visit[i] = false;
        }
        
    }

    }
