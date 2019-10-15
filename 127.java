import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import javafx.util.Pair;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        HashMap<String, ArrayList<String>> dic = new HashMap<String, ArrayList<String>>();
        int len = beginWord.length();
        for (int i = 0; i < len; ++i) {
            String newWord = beginWord.substring(0, i) + "*" + beginWord.substring(i+1, len);
            if (!dic.containsKey(newWord)) {
                dic.put(newWord, new ArrayList<String>());
            }
            dic.get(newWord).add(beginWord);
        }
        for (String temp : wordList) {
            for (int i = 0; i < len; ++i) {
                String newWord = temp.substring(0, i) + "*" + temp.substring(i+1, len);
                if (!dic.containsKey(newWord)) {
                    dic.put(newWord, new ArrayList<String>());
                }
                dic.get(newWord).add(temp);
            }
        }
        Queue<Pair<String, Integer>> queue = new LinkedList<Pair<String, Integer>>();
        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        queue.offer(new Pair(beginWord, 1));
        visited.put(beginWord, true);
        String newWord = "";
        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.poll();
            String key = node.getKey();
            int val = node.getValue();
            for (int i = 0; i < len; ++i) {
                newWord = key.substring(0, i) + "*" + key.substring(i+1, len);
                for (String t : dic.get(newWord)) {
                    if (!visited.getOrDefault(t, false)) {
                        if (endWord.equals(t)) {
                            return val + 1;
                        } else {
                            queue.offer(new Pair(t, val + 1));
                            visited.put(t, true);
                        }

                    }
                }
                newWord = "";
            }
        }
        return 0;

    }
}     