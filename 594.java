class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int temp : nums){
        	map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        int result = 0;
        for(int temp : map.keySet()){
        	if(map.containsKey(temp + 1)){
        		result = Math.max(result, map.get(temp) + map.get(temp+1));
        	}
        }
        return result;
    }
}