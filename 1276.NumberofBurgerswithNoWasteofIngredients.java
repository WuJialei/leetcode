class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> ans = new ArrayList<>();
        int m = tomatoSlices;
        int n = cheeseSlices;
        int x = m - 2*n;
        if ( x < 0 || (x%2 == 1) || (n-x/2 < 0)) {
            return ans;
        }
        ans.add(x/2);
        ans.add(n-x/2);
        return ans;
    }
}