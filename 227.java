class Solution {

    private Stack<Integer> nums;

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        nums = new Stack<Integer>();
        int num = 0;
        char ops = '+';
        for (int i = 0; i < s.length(); ++i) {
            char tmp = s.charAt(i);
            if (tmp >= '0') {
                num = num * 10 + tmp - '0';
            }
            if ((tmp < '0' && tmp != ' ' )|| (i == s.length() - 1)) {
                switch (ops) {
                    case '+':
                        nums.push(num);
                        break;
                    case '-':
                        nums.push(-num);
                        break;
                    case '*':
                        nums.push(num * nums.pop());
                        break;
                    case '/':
                        nums.push(nums.pop() / num);
                        break;
                    default:
                        break;
                }
                num = 0;
                ops = tmp;
            }
        }
        int ret = 0;
        while (!nums.isEmpty()) {
            ret += nums.pop();
        }
        return ret;
    }
}