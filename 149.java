class Solution {

    public int gcd (int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a%b);
        }
    }

    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int n = points.length;
        if (n < 3) {
            return n;
        }
        int ans = 1;
        int w, h, d, t;
        for (int i = 0; i < n; ++i) {
            map.clear();
            d = 0;
            h = 1;
            w = 1;
            t = 1;
            for (int j = i+1; j < n; ++j) {
                int dy = points[i][1] - points[j][1];
                int dx = points[i][0] - points[j][0];
                if ( dy == 0 && dx == 0) {
                    ++d;
                } else if (dx == 0) {
                    ++h;
                    t = Math.max(t, h);
                } else if (dy == 0) {
                    ++w;
                    t = Math.max(t, w);
                } else {
                    int g = gcd(dy, dx);
                    if (g != 0) {
                        dy /= g;
                        dx /= g;
                    }
                    String key = String.valueOf(dy) + "/" + String.valueOf(dx);
                    map.put(key, map.getOrDefault(key, 1) + 1);
                    t = Math.max(t, map.get(key));
                }
            }
            ans = Math.max(ans, d + t);
        }
        return ans;
    }
}