class Solution {
    public int majorityElement(int[] nums) {
    	/*
    	Arrays.sort(nums);
        return nums[nums.length / 2];
    	*/
    	Map<Integer, Integer> map = getMap(nums);
    	int val = 0;
    	int ret = 0;
    	for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    		if (entry.getValue() > val) {
    			val = entry.getValue();
    			ret = entry.getKey();
    		}
    	}
    	return ret;
        
    }

    public Map<Integer, Integer> getMap(int[] nums) {
    	Map<Integer, Integer> result = new HashMap<>();
    	for (int num : nums) {
    		if (result.containsKey(num)) {
    			result.put(num, result.get(num) + 1);
    		} else {
    			result.put(num, 1);
    		}
    	}
    	return result;
    }

}
