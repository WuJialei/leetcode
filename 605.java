class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed == null || flowerbed.length == 0){
        	return false;
        }
        if(n == 0){
        	return true;
        }
        int len = flowerbed.length;
        if(len == 1){
            if(flowerbed[0] == 0 && n == 1){
                return true;
            }
        }
        if(len >= 2){
        	if(flowerbed[0] == 0 && flowerbed[1] == 0){
        		flowerbed[0] = 1;
        		--n;
        	}
        	
        }
        for(int i = 1; i < len - 1; ++i){
        	if(n < 1){
        		return true;
        	}
        	else if(flowerbed[i] == 1){
        		continue;
        	}
        	else{
        		if(flowerbed[i-1] == 0 && flowerbed[i+1] == 0){
        			flowerbed[i] = 1;
        			--n;
        		}
        		else{
        			continue;
        		}
        	}
        }
        if(len >= 2){
        	if(flowerbed[len-1] == 0 && flowerbed[len-2] == 0){
        		flowerbed[len-1] = 1;
        		--n;
        	}
        	if(n < 1){
        		return true;
        	}
        }
        return false;
    }
}