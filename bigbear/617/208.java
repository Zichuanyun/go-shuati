class TrieNode{
    boolean isEnd;
    TrieNode[] child = new TrieNode[26];
    TrieNode(){
        isEnd = false;
        for(int i = 0; i < 26; i++){
            child[i] = null;
        }
    }
}

public class Trie {

    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        int n = word.length();
        TrieNode traveler = root;
        for(int i = 0; i < n; ++i){
            int index = word.charAt(i) - 'a';
            if(traveler.child[index] == null){
                traveler.child[index] = new TrieNode();
            }
            traveler = traveler.child[index];
        }
        traveler.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int n = word.length();
        TrieNode traveler = root;
        for(int i = 0; i < n; ++i){
            int index = word.charAt(i) - 'a';
            if(traveler.child[index] == null){
                return false;
            }
            traveler = traveler.child[index];
        }
        return traveler != null && traveler.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int n = prefix.length();
        TrieNode traveler = root;
        for(int i = 0; i < n; ++i){
            int index = prefix.charAt(i) - 'a';
            if(traveler.child[index] == null){
                return false;
            }
            else{
                traveler = traveler.child[index];
            }
        }
        return traveler != null;
    }
}



/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */