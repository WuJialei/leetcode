class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int len = nums.length;
        if (len < k || len%k != 0) {
            return false;
        }
        int cnt = len/k;
        List<Integer>[] lists = new ArrayList[cnt];
        for (int i = 0; i < cnt; ++i) {
            lists[i] = new ArrayList<>();
        }
        Arrays.sort(nums);
        int start = 0;
        for (int num : nums) {
            int index = start;
            while (true) {
                if (index >= cnt) {
                    return false;
                }
                if (lists[index].size() == 0) {
                    lists[index].add(num);
                    if (lists[index].size() == k) {
                        ++start;
                    }
                    break;
                }
                if (lists[index].size() < k) {
                    int temp = lists[index].size();
                    if (num - lists[index].get(temp-1) == 1) {
                        lists[index].add(num);
                        if (lists[index].size() == k) {
                            ++start;
                        }
                        break;
                    }                    
                }
                ++index;
            }
            
        }
        return true;
    }
}