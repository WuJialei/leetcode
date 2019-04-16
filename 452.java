class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0)
        {
        	return 0;
        }
        int cnt = 1;
        Arrays.sort(points, (a, b)->(a[1] - b[1]));
        int cur_pos = points[0][1];
        for(int i = 1; i < points.length; ++i)
        {
        	if(points[i][0] <= cur_pos)
        	{
        		continue;
        	}
        	++cnt;
        	cur_pos = points[i][1];
        }
        return cnt;
    }
}