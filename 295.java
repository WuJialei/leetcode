import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> low;
    PriorityQueue<Integer> high;
    /** initialize your data structure here. */
    public MedianFinder() {
        high = new PriorityQueue<Integer>();
        low = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return b.intValue() - a.intValue();
            }
        });
    }
    
    public void addNum(int num) {
        low.offer(num);
        high.offer(low.peek());
        low.poll();
        if (low.size() < high.size()) {
            low.offer(high.peek());
            high.poll();
        }
    }
    
    public double findMedian() {
        return low.size() == high.size() ? (double)(low.peek() + high.peek())/2 : low.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */