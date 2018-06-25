class Trie {
    
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        
        for(int i = 0; i < word.length(); i++){
            int index = (int)(word.charAt(i) - 'a');
            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }
           node = node.children[index];
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = find(prefix);
        return node != null;
    }
    
    private TrieNode find(String word){
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            int index  = (int)(word.charAt(i) - 'a');
            if(node.children[index] == null){
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

    private class TrieNode{
        TrieNode[] children;
        boolean isWord;
        public TrieNode(){
            children = new TrieNode[26];
            isWord = false;
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
