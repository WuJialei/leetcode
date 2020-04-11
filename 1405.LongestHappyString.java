class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int[][] nums = new int[3][2];
        for (int i = 0; i < 3; ++i) {
            nums[i][0] = i;
        }
        nums[0][1] = a;
        nums[1][1] = b;
        nums[2][1] = c;
        StringBuilder sb = new StringBuilder("");
        List<Character> list = new ArrayList<>();
        boolean flag = false;
        while(true) {
            Arrays.sort(
                nums,
                (x, y) -> y[1] - x[1]
            );
            // 排序取最多的两个单个输出，知道最多的两个里面有一个为0，表示
            // 剩下最多一个数
            int cnt = 2;
            while (cnt > 0) {
                if (nums[2-cnt][1] > 0) {
                    list.add((char)(nums[2-cnt][0] + 'a'));
                    --nums[2-cnt][1];
                } else {
                    flag = true;
                    break;
                }
                --cnt;
            }
            if (flag) {
                break;
            }
        }
        Arrays.sort(
            nums,
            (x, y) -> y[1] - x[1]
        );
        int index = nums[0][0];
        int val = nums[0][1];
        // 对剩下的最多的一个数，碰到相同就重复
        for (int i = 0; i < list.size(); ++i) {
            sb.append(list.get(i));
            if (list.get(i) - 'a' == index && val > 0) {
                sb.append(list.get(i));
                --val;
            }
        }
        return sb.toString();
    }
}