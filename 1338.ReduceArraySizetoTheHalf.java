class Solution {
    public int minSetSize(int[] arr) {
        int len = arr.length;
        int half = (len + 1)/2;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list, (a, b) -> b-a);
        int i = 0;
        int ans = 0;
        int sum = 0;
        while (i < list.size() && sum < half) {
            sum += list.get(i);
            ++i;
            ++ans;
                
        }
        return ans;
        
    }
}