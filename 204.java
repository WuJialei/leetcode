class Solution {
    public int countPrimes(int n) {
        if(n < 2){
        	return 0;
        }
        boolean[] flag = new boolean[n+1];
        int cnt = 0;
        for(int i = 2; i < n; ++i){
        	if(flag[i]){
        		continue;
        	}
        	cnt++;
        	for(int j = i; j < n;){
        		flag[j] = true;
        		j += i;
        	}
        }
        return cnt;
    }
}


// 204. Count Primes