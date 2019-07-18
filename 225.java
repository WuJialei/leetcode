class MyStack {


	private Queue<Integer> cur = new LinkedList<Integer>();

    /** Initialize your data structure here. */
    public MyStack() {
        cur = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        cur.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Queue<Integer> temp = new LinkedList<Integer>();
        int len = cur.size();
        if(len == 1){
        	return cur.poll();
        }
        else{
        	while(len > 1){
	        	temp.offer(cur.poll());
                --len;
	        }
	        int result = cur.poll();
	        while(!temp.isEmpty()){
	        	cur.offer(temp.poll());
	        }
	        return result;
        }
    }
    
    /** Get the top element. */
    public int top() {
        Queue<Integer> temp = new LinkedList<Integer>();
        int len = cur.size();
        if(len == 1){
        	return cur.peek();
        }
        else{
        	while(len > 1){
	        	temp.offer(cur.poll());
                --len;
	        }
	        int result = cur.peek();
	        temp.offer(cur.poll());
	        while(!temp.isEmpty()){
	        	cur.offer(temp.poll());
	        }
	        return result;
        }
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return cur.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
