struct Node {
    int w = -1;
    Node *next[26] = {NULL};
};

// struct pair_hash {
//     size_t operator () (const pair<string, int> &pr) const {
//         hash<string> hashFn;
//         return hashFn(pr.first);
//     }
// };
class Trie {
public:
    Node *root;
    Trie() {
        root = new Node();
    }
    void insert(int w, const string &s) {
        auto x = root;
        for(char c: s) {
            auto &pnext = x->next[c - 'a'];
            if(!pnext) {
                pnext = new Node();
            }
            x = pnext;
        }
        x->w = w;
    }
    unordered_map<string, int> queryPrefix(string s) {
        auto x = root;
        for(char c: s) {
            auto pnext = x->next[c - 'a'];
            if(!pnext) return {};
            x = pnext;
        }
        unordered_map<string, int> res;
        getStrings(x, s, res);
        return res;
    }
    void getStrings(Node *node, string &path, unordered_map<string, int> &res) {
        if(!node) return;
        if(node->w >= 0) {
            res.emplace(path, node->w);
        }
        for(int i = 0; i < 26; i++) {
            path.push_back(i + 'a');
            getStrings(node->next[i], path, res);
            path.pop_back();
        }
    }
};
class WordFilter {
    Trie pTree, sTree;
public:
    WordFilter(vector<string> words) {
        for(int i = 0; i < words.size(); i++) {
            auto word = words[i];
            pTree.insert(i, word);
            reverse(word.begin(), word.end());
            sTree.insert(i, word);
        }
    }
    
    int f(string prefix, string suffix) {
        reverse(suffix.begin(), suffix.end());
        auto pMap = pTree.queryPrefix(prefix);
        auto sMap = sTree.queryPrefix(suffix);
        int ans = -1;
        for(auto &pr: pMap) {
            if(sMap.count(reverseCopy(pr.first))) {
                ans = max(ans, pr.second);
            }
        }
        for(auto &pr: sMap) {
            if(pMap.count(reverseCopy(pr.first))) {
                ans = max(ans, pr.second);
            }
        }
        return ans;
    }
    string reverseCopy(string s) {
        reverse(s.begin(), s.end());
        return s;
    }
};

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
