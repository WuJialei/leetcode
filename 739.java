class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> myStack = new Stack<Integer>();
        int[] result = new int[T.length];
        for(int i = 0; i < T.length; ++i){
        	while(!myStack.empty() && T[i] > T[myStack.peek()]){
        		int temp = myStack.pop();
        		result[temp] = i - temp;
        	}
        	myStack.push(i);
        }
        return result;
    }
}