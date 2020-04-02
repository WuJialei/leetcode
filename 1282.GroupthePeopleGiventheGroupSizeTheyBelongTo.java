class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; ++i) {
            int key = groupSizes[i];
            if (!map.containsKey(key)) {
                map.put(groupSizes[i], new ArrayList<>());
            }
            map.get(key).add(i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int key = entry.getKey();
            List<Integer> value = entry.getValue();
            int i = 0;
            while (i < value.size()) {
                int cnt = key;
                List<Integer> temp = new ArrayList<>();
                while (cnt > 0) {
                    temp.add(value.get(i));
                    ++i;
                    --cnt;
                }
                ans.add(temp);
            }
        }
        return ans;
    }
}