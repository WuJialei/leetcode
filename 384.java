class Solution {

	int[] arrays;
	int[] orignal;


    public Solution(int[] nums) {
        orignal = nums;
        arrays = orignal.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        arrays = orignal;
        orignal = arrays.clone();
        return orignal;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = 0; i < arrays.length; ++i) {
        	swapAt(i, getRandom(i, arrays.length));
        }
        return arrays;
    }

    public int getRandom(int index, int len) {
    	Random random = new Random();
    	int result = index + random.nextInt(len - index);
    	return result;
    }

    public void swapAt(int i, int j) {
    	int temp = arrays[i];
    	arrays[i] = arrays[j];
    	arrays[j] = temp; 
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */