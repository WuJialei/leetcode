class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int temp : nums){
        	if(temp > max1){
        		max3 = max2;
        		max2 = max1;
        		max1 = temp;
        	}
        	else if(temp > max2){
        		max3 = max2;
        		max2 = temp;
        	}
        	else if(temp > max3){
        		max3 = temp;
        	}

        	if(temp < min1){
        		min2 = min1;
        		min1 = temp;
        	}
        	else if(temp < min2){
        		min2 = temp;
        	}
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
    }
}