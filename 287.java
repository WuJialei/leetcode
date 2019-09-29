class Solution {
    public int findDuplicate(int[] nums) {
        /*
        int slow = 0;
        int fast = 0;
        do{
        	slow = nums[slow];
        	fast = nums[nums[fast]];
        }while(slow != fast);
        fast = 0;
        while(slow != fast){
        	slow = nums[slow];
        	fast = nums[fast];
        }
        return slow;
        */
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int tmp : nums) {
                if (tmp <= mid) {
                    ++cnt;
                }
            }
            if (cnt <= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
