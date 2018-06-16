class Trie {

    public Trie[] tries = new Trie[26];
    public boolean hasWord = false;
    
    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie cur = this;
        int i = 0;
        while(i < word.length()) {
            int c = word.charAt(i) - 'a';
            if(cur.tries[c] == null) {
                cur.tries[c] = new Trie();
            }
            cur = cur.tries[c];
            i++;
        }
        cur.hasWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie cur = this;
        int i = 0;
        while(i < word.length()) {
            int c = word.charAt(i) - 'a';
            if(cur.tries[c] == null) {
                return false;
            }
            cur = cur.tries[c];
            i++;
        }
        return cur.hasWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie cur = this;
        int i = 0;
        while(i < prefix.length()) {
            int c = prefix.charAt(i) - 'a';
            if(cur.tries[c] == null) {
                return false;
            }
            cur = cur.tries[c];
            i++;
        }
        return true;
    }
}