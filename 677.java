class MapSum {

	private class Node {
		int value;
		Map<Character, Node> next;
        public Node() {
            value = 0;
            next = new HashMap<>();
        }
	}

	private Node root; 

    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();
    }
    
    public void insert(String key, int val) {
    	Node cur = root;
        for(char c : key.toCharArray()) {
        	if (cur.next.get(c) == null) {
        		cur.next.put(c, new Node());
        	}
        	cur = cur.next.get(c);
        }
        cur.value = val;
    }
    
    public int sum(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()) {
        	if (cur.next.get(c) == null) {
        		return 0;
        	}
        	cur = cur.next.get(c);
        }
        return sumVal(cur);
    }

    public int sumVal(Node node) {
    	int cnt = node.value;
    	for (char c : node.next.keySet()) {
    		cnt += sumVal(node.next.get(c));
    	}
    	return cnt;
    } 

}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */