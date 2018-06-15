class Trie {
    public TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (char c: word.toCharArray()) {
            if (!cur.map.containsKey(c)) {
                TrieNode newNode = new TrieNode(c);
                cur.map.put(c, newNode);
                cur = newNode;
            } else {
                cur = cur.map.get(c);
            }
        }
        cur.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (char c: word.toCharArray()) {
            if (cur.map.containsKey(c)) {
                cur = cur.map.get(c);
            } else {
                return false;
            }
        }
        if (cur.isEnd) {
            return true;
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c: prefix.toCharArray()) {
            if (cur.map.containsKey(c)) {
                cur = cur.map.get(c);
            } else {
                return false;
            }
        }
        return true;
    }
    class TrieNode {
        public boolean isEnd = false;
        private char c;
        public HashMap<Character, TrieNode> map = new HashMap<>();
        public TrieNode(char c) {
            this.c = c;
        }
        public TrieNode() {}
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
