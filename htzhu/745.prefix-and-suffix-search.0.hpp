struct Node {
    int w = -1;
    Node *next[27] = {NULL};
};

class Trie {
    Node *root;
public:
    Trie() {
        root = new Node();
    }
    void insert(int w, const list<char> &s) {
        auto x = root;
        for(char c: s) {
            auto &pnext = x->next[c - 'a'];
            if(!pnext) pnext = new Node();
            x = pnext;
            x->w = w;
        }
    }
    int query(const string &s) {
        auto x = root;
        for(char c: s) {
            auto pnext = x->next[c - 'a'];
            if(!pnext) return -1;
            x = pnext;
        }
        return x->w;
    }

};
class WordFilter {
    Trie trie;
public:
    WordFilter(vector<string> words) {
        for(int w = 0; w < words.size(); w++) {
            auto &word = words[w];
            list<char> s(word.begin(), word.end());
            int n = word.size();
            for(int i = n; i >= 0; i--) {
                if(i == n) s.push_front('z' + 1);
                else s.push_front(word[i]);
                trie.insert(w, s);
            }
        }
    }
    
    int f(string prefix, string suffix) {
        auto s = suffix + string(1, 'z' + 1) + prefix;
        return trie.query(s);
    }
};

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
