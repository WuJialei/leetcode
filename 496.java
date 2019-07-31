class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        Stack<Integer> myStack = new Stack<Integer>(); 
        int[] result = new int[nums1.length];
        for(int temp : nums2){
        	while(!myStack.empty() && temp > myStack.peek()){
        		myMap.put(myStack.pop(), temp);
        	}
        	myStack.push(temp);
        }
        for(int i = 0; i < nums1.length; ++i){
        	if(myMap.containsKey(nums1[i])){
        		result[i] = myMap.get(nums1[i]);
        	}
        	else{
        		result[i] = -1;
        	}
        }
        return result;
    }
}