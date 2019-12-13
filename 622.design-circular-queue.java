/*
 * @lc app=leetcode id=622 lang=java
 *
 * [622] Design Circular Queue
 */

// @lc code=start
class MyCircularQueue {

    int[] queue;
    int k;
    // 代表头的当前位置
    int front;
    // 要插入的地方
    int rear; 
    int cnt;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.k = k;
        queue = new int[k];
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        queue[rear] = value;
        rear = (rear + 1) % k;
        ++cnt;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = front == k - 1 ? 0 : front + 1;
        --cnt;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return rear == 0 ? queue[k - 1] : queue[rear - 1];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return cnt == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return cnt == k;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
// @lc code=end

