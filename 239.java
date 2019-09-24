import java.util.Queue;

class Solution {

    public int getMin(Queue<Integer> q) {
        int minVal = q.peek();
        for (int tmp : q) {
            minVal = tmp > minVal? tmp: minVal;
        }
        return minVal;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        /*
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        int len = nums.length;
        int index = 0;
        int retLen = len - k + 1;
        int[] ret = new int[retLen];
        int begin = 0;
        while (index < len) {
            while (queue.size() < k) {
                queue.offer(nums[index++]);
            }
            int tmp = getMin(queue);
            ret[begin++] = tmp;
            queue.poll();
        }
        return ret;
        */
        int len = nums.length;
        if (len == 0 || k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[] start2left = new int[len];
        int[] end2right = new int[len];
        int[] ret = new int[len - k + 1];
        start2left[0] = nums[0];
        for (int i = 1; i < len; ++i) {
            if (i % k == 0) {
                start2left[i] = nums[i];
            } else {
                start2left[i] = Math.max(start2left[i-1], nums[i]);
            }
        }
        end2right[len - 1] = nums[len-1];
        for (int i = len - 2; i >= 0; --i) {
            if (((i+1)) % k == 0) {
                end2right[i] = nums[i];
            } else {
                end2right[i] = Math.max(end2right[i+1], nums[i]);
            }
        }

        for (int i = 0; i < len - k + 1; ++i) {
            ret[i] = Math.max(end2right[i], start2left[i + k - 1]);
        }
        return ret;
    }
}