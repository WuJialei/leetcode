class Solution {
    public int arrangeCoins(int n) {
        if(n <= 1)
        {
        	return n;
        }
        long l = 1;
        long h = n/2 + 1;
        while(l <= h)
        {
        	long mid = l + (h - l)/2;
        	long total = (1 + mid)* mid/2;
        	if(total == n)
        	{
        		return (int)mid;
        	}
        	else if(total > n)
        	{
        		h = mid - 1;
        	}
        	else
        	{
        		l = mid + 1;
        	}
        }
        return (int)h;
    }
}