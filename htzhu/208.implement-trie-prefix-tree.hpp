struct Node {
    bool isEnd = false;
    vector<Node*> next = decltype(next)(26, NULL);
    Node() {}
};

class Trie {
    Node *root;
public:
    /** Initialize your data structure here. */
    Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        auto p = root;
        for(auto c: word) {
            auto &q = p->next[c - 'a'];
            if(!q) q = new Node();
            p = q;
        }
        p->isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        auto p = root;
        for(auto c: word) {
            auto q = p->next[c - 'a'];
            if(!q) return false;
            p = q;
        }
        return p->isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        auto p = root;
        for(auto c: prefix) {
            auto q = p->next[c - 'a'];
            if(!q) return false;
            p = q;
        }
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * bool param_2 = obj.search(word);
 * bool param_3 = obj.startsWith(prefix);
 */
