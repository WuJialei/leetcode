import java.awt.List;
import java.util.HashMap;

class Solution {

    private String s;
    private List<String> wordDict;
    HashMap<Integer, List<String>> map;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = wordDict;
        map = new HashMap<Integer, List<String>>();
        return dfs(0);
    }

    public List<String> dfs(int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        List<String> temp = new ArrayList<String>();
        if (start == s.length()) {
            temp.add("");
        }
        for (int i = start; i < s.length(); ++i) {
            if (wordDict.contains(s.substring(start, i+1))) {
                List<String> next = dfs(i+1);
                for (String t : next) {
                    temp.add(s.substring(start, i+1) + (t==""?"":(" "+t)));
                }
            }
        }
        map.put(start, temp);
        return temp;
    }


}