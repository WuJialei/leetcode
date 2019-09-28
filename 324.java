class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length;
        Arrays.sort(nums);
        int[] tmp = new int[len];
        int index1 = 0;
        int index2 = len - 1;
        int index = 0;
        if (len % 2 == 0) {
            index1 = len/2 - 1;   
        } else {
            index1 = len/2; 
        }
        for (; index < len; ++index) {
            tmp[index] = nums[index1--];
            if (index + 1 < len) {
                tmp[++index] = nums[index2--];
            }            
        }
        for (int i = 0; i < len; ++i) {
            nums[i] = tmp[i];
        }

    }
}