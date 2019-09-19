import java.util.Map;
import java.util.Stack;

class Solution {

    private Map<String, Integer> map = new HashMap<>();

    private Stack<Integer> nums;

    public void init() {
        map.put("+", 1);
        map.put("-", 2);
        map.put("*", 3);
        map.put("/", 4);
        nums = new Stack<Integer>();
    }

    public int compute(int p, int q, int flag) {
        int ret = 0;
        switch (flag) {
            case 1 :
                ret = p + q;
                break;
            case 2 :
                ret = p - q;
                break;
            case 3 :
                ret = p * q;
                break;
            case 4 :
                ret = p / q;
                break;
            default :
                break;
        }
        return ret;
    }

    public int evalRPN(String[] tokens) {
        init();
        for (String tmp : tokens) {
            if (map.containsKey(tmp)) {
                int a = nums.pop();
                int b = nums.pop();
                int c = compute(b, a, map.get(tmp));
                nums.push(c);
            } else {
                nums.push(Integer.parseInt(tmp));
            }
        }
        return nums.pop();
    }
}