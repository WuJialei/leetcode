class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, new Comparator<String>() {
            public int compare (String a, String b) {
                return (b+a).compareTo(a+b);
            }
        });
        
        String ret = "";
        for (String str : strs) {
            ret += str;
        }
        
        if (ret.startsWith("0")) {
            return "0";
        }

        
        return ret;
    }
}