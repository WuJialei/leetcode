import java.util.ArrayList;
import java.util.Set;

class Solution {

    private TrieNode root = new TrieNode();
    private Set<String> set = new HashSet<String>();
    private boolean[][] visited;
    private int m, n;
    private char[][] board;
    private int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    private class TrieNode {
        TrieNode[] nodes = new TrieNode[26];
        String endWord;
    }

    public void insert(String word, TrieNode node) {
        if (word == null || word.length() == 0) {
            return;
        }
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (node.nodes[index] == null) {
                node.nodes[index] = new TrieNode();
            }
            node = node.nodes[index];
        }
        node.endWord = word;
    }


    public List<String> findWords(char[][] board, String[] words) {
        for (String temp : words) {
            insert(temp, root);
        }
        this.m = board.length;
        this.n = board[0].length;
        this.board = board;
        this.visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dfs(root, i, j);
            }
        }
        List<String> ans = new ArrayList<String>(set);
        return ans;
    }


    public void dfs (TrieNode node, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
            return;
        }
        int index = board[i][j] - 'a';
        if (node.nodes[index] == null) {
            return;
        }
        if (node.nodes[index].endWord != null) {
            set.add(node.nodes[index].endWord);
        }
        visited[i][j] = true;
        for(int c = 0; c < 4; ++c) {
            dfs(node.nodes[index], i+direction[c][0], j+direction[c][1]);
        }
        visited[i][j] = false;
    }
}