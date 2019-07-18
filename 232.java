class MyQueue {

    private Stack<Integer> cur;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        cur = new Stack<Integer>();
    }

    
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        cur.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Stack<Integer> temp = new Stack<Integer>();
        while(!cur.empty()){
            temp.push(cur.pop());
        }
        int result = temp.pop();
        while(!temp.empty()){
            cur.push(temp.pop());
        }
        return result;
    }
    
    /** Get the front element. */
    public int peek() {
        Stack<Integer> temp = new Stack<Integer>();
        while(!cur.empty()){
            temp.push(cur.pop());
        }
        int result = temp.peek();
        while(!temp.empty()){
            cur.push(temp.pop());
        }
        return result;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return cur.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */