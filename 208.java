class Trie {

    private class Node {
        Node[] childs = new Node[26];
        boolean isLeaf;
    }

    private Node root = new Node();

    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        insert(word, root);
    }

    public void insert(String word, Node node) {
        if (word == null || word.length() == 0) {
            return;
        }
        int index = word.charAt(0) - 'a';
        if (node.childs[index] == null) {
            node.childs[index] = new Node();
        }
        if (word.length() == 1) {
            node.childs[index].isLeaf = true;
        } else {
            insert(word.substring(1), node.childs[index]);
        }
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(word, root);
    }

    public boolean search(String word, Node node) {
        if (word == null || word.length() == 0) {
            return true;
        }
        if (node == null) {
            return false;
        }
        int index = word.charAt(0) - 'a';
        if (node.childs[index] == null) {
            return false;
        } else if (word.length() == 1) {
            return node.childs[index].isLeaf;
        } else {
            return search(word.substring(1), node.childs[index]);
        }
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return startsWith(prefix, root);
    }

    public boolean startsWith(String prefix, Node node) {
        if (prefix == null || prefix.length() == 0) {
            return true;
        }
        if (node == null) {
            return false;
        }
        int index = prefix.charAt(0) - 'a';
        if (node.childs[index] == null) {
            return false;
        } else {
            return startsWith(prefix.substring(1), node.childs[index]);
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */