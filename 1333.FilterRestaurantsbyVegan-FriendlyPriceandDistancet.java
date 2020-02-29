import java.util.List;

class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < restaurants.length; ++i) {
            if (veganFriendly == 1 && restaurants[i][2] == 0) {
                continue;
            }
            if (restaurants[i][3] <= maxPrice && restaurants[i][4] <= maxDistance) {
                ans.add(i);
            }
        }
        Collections.sort(
            ans,
            (a, b) -> {
                if (restaurants[b][1] == restaurants[a][1]) {
                    return restaurants[b][0] - restaurants[a][0];
                } else {
                    return restaurants[b][1] - restaurants[a][1];
                }

            }
        );
        int len = ans.size();
        for (int i = 0; i < len; ++i) {
            ans.add(restaurants[ans.get(i)][0]);
        }
        return ans.subList(len, len*2);
    }
}