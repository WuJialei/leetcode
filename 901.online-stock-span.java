/*
 * @lc app=leetcode id=901 lang=java
 *
 * [901] Online Stock Span
 */

// @lc code=start
class StockSpanner {

    List<Integer> list;
    Stack<Integer> stack;
    int index;

    public StockSpanner() {
        // 存个数
        index = -1;
        // 存结果
        list = new ArrayList<Integer>();
        // 最小栈
        stack = new Stack<Integer>();
    }
    
    public int next(int price) {
        int ret = 1;
        int cur = index;
        while (!stack.isEmpty() && price >= stack.peek()) {
            ret += list.get(cur);
            cur -= list.get(cur);
            stack.pop();
        }
        stack.push(price);
        list.add(ret);
        ++index;
        return ret;      
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
// @lc code=end

