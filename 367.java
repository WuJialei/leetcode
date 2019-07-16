class Solution {
    public boolean isPerfectSquare(int num) {
    	/*
        int cnt = 1;
        while(num > 0){
        	num -= cnt;
        	cnt += 2;
        }
        return num == 0;
        */
        if(num == 1){
            return true;
        }
        long left = 1, right = num;        
        while(left <= right){
        	long mid = left + (right - left)/2;
        	long temp = mid * mid;
        	if(temp == num){
        		return true;
        	}
        	else if(temp < num){
        		left = mid + 1;
        	}
        	else{
        		right = mid - 1;
        	}

        }
        return false;
    }
}