class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<Integer> ();
        int[] ans = new int[nums1.length];
        for (int num : nums2) {
            if (stack.isEmpty()) {
                stack.push(num);
            } else {
                // 单调栈是严格单调递减的
                while (!stack.isEmpty() && stack.peek() < num) {
                    map.put(stack.pop(), num);
                }
                stack.push(num);
            }
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        for (int i = 0; i < nums1.length; ++i) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
