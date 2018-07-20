struct Node {
    bool isEnd = false;
    Node *next[26] = {NULL};
};

class WordDictionary {
    Node *root;
public:
    /** Initialize your data structure here. */
    WordDictionary() {
        root = new Node();
    }
    
    /** Adds a word into the data structure. */
    void addWord(string word) {
        auto x = root;
        for(auto c: word) {
            auto &p = x->next[c - 'a'];
            if(!p) p = new Node();
            x = p;
        }
        x->isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    bool search(string word) {
        return search(root, 0, word);
    }
    bool search(Node *node, int i, const string &s) {
        if(!node) return false;
        if(i == s.size()) return node->isEnd;
        if(s[i] == '.') {
            for(int j = 0; j < 26; j++) {
                if(search(node->next[j], i + 1, s)) return true;
            }
        } else {
            return search(node->next[s[i] - 'a'], i + 1, s);
        }
        return false;
    }
};

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * bool param_2 = obj.search(word);
 */
