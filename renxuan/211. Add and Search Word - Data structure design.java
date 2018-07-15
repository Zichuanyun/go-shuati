class WordDictionary {
    class Trie {
        boolean isWord;
        Trie[] children;
        Trie() {
            children = new Trie[26];
        }
    }
    
    Trie root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie node = root;
        for(char c : word.toCharArray()) {
            if(node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new Trie();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(root, word);
    }
    
    private boolean search(Trie node, String word) {
        if(node == null) return false;
        if(word.equals("")) return node.isWord;
        char[] charArray = word.toCharArray();
        for(int i = 0; i < charArray.length; ++i) {
            if(charArray[i] == '.') {
                for(int j = 0; j < 25; ++j) {
                    if(search(node.children[j], word.substring(i + 1)))
                        return true;
                }
                return false;
            }
            else {
                if(node.children[charArray[i] - 'a'] == null) return false;
                return search(node.children[charArray[i] - 'a'], word.substring(i + 1));
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
 