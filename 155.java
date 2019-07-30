class MinStack {

    private Stack<Integer> myStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();
    private int minValue;
    /** initialize your data structure here. */
    public MinStack() {
        myStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
        minValue = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        myStack.push(x);
        minValue = Math.min(x, minValue);
        minStack.push(minValue);
    }
    
    public void pop() {
        myStack.pop();
        minStack.pop();
        if(minStack.empty()){
            minValue = Integer.MAX_VALUE;
        }
        else{
            minValue = minStack.peek();
        }
        
    }
    
    public int top() {
        return myStack.peek();
    }
    
    public int getMin() {        
        return minValue;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */