class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        if (numerator < 0 || denominator < 0) {
            if (!(numerator < 0 && denominator < 0)) {
                ans.append("-");
            }
        }
        long beichushu = Math.abs((long)numerator);
            long chushu = Math.abs((long)denominator);
        long shang = beichushu / chushu;
        ans.append(shang);
        long yushu = beichushu % chushu;
        if (yushu == 0) {
            return ans.toString();
        }
        ans.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        while (yushu != 0) {
            if (map.containsKey(yushu)) {
                ans.insert(map.get(yushu), "(");
                ans.append(")");
                break;
            }
            map.put(yushu, ans.length());
            beichushu = yushu * 10;
            shang = beichushu / chushu;
            yushu = beichushu % chushu;
            ans.append(shang);
        }
        return ans.toString();
        
    }
}