class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : nums){
        	map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer>[] temp = new List[nums.length + 1];
        for(int j : map.keySet()){
        	int frequency = map.get(j);
        	if(temp[frequency] == null){
        		temp[frequency] = new ArrayList<Integer>();
        	}
        	temp[frequency].add(j);
        }
        for(int t = temp.length - 1; res.size() < k && t >= 0; --t){
        	if(temp[t] != null){
        		res.addAll(temp[t]);
        	}
        }
        return res;

    }
}