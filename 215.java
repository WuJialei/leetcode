class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> temp = new PriorityQueue<Integer>();
        for(int i : nums){
        	temp.offer(i);
        	if(temp.size() > k){
        		temp.poll();
        	}
        }
        return temp.peek();
    }
}