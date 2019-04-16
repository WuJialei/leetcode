class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(s == null)
        {
        	return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt = 0;
        for(int i = 0, j = 0; i < g.length && j < s.length;)
        {
        	if(s[j] >= g[i])
        	{
        		++cnt;
        		++i;
        		++j;
        	}
        	else
        	{
        		++j;
        	}
        }
        return cnt;
    }
}