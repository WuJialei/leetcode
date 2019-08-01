class Solution {
    public int[] nextGreaterElements(int[] nums) {
    	/*
        if(nums == null || nums.length == 0){
    		return null;
    	}
        */
    	int len = nums.length;
        int[] result = new int[len];
        Stack<Integer> myStack = new Stack<Integer>();
        Arrays.fill(result, -1);
        for (int i = 0; i < 2*len; ++i) {
        	int temp = nums[i%len];
        	while(!myStack.empty() && temp > nums[myStack.peek()]){
        		result[myStack.pop()] = temp;
        	}
        	if(i < len){
        		myStack.push(i);
        	}        	
        }
        return result;
    }
}