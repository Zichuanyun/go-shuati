class Solution {
    vector<int> id, sz;
    unordered_map<string, int> s2id;
public:
    bool areSentencesSimilarTwo(vector<string>& words1, vector<string>& words2, vector<pair<string, string>> pairs) {
        if(words1.size() != words2.size()) return false;
        for(auto &s: words1) {
            addString(s);
        }
        for(auto &s: words2) {
            addString(s);
        }

        for(auto &pr: pairs) {
            auto &s1 = pr.first, &s2 = pr.second;
            addString(s1);
            addString(s2);
            connect(s2id[s1], s2id[s2]);
        }

        for(int i = 0; i < words1.size(); i++) {
            if(!isConnected(s2id[words1[i]], s2id[words2[i]]))
                return false;
        }
        return true;
    }
    void addString(const string &s) {
        if(!s2id.count(s)) {
            int t = s2id.size();
            id.push_back(t);
            sz.push_back(1);
            s2id[s] = t;
        }
    }
    int findp(int x) {
        return x == id[x] ? x : (id[x] = findp(id[x]));
    }
    void connect(int x, int y) {
        int p = findp(x), q = findp(y);
        if(p == q) return;
        if(sz[p] < sz[q]) swap(p, q);
        id[q] = p;
        sz[p] += sz[q];
    }
    bool isConnected(int x, int y) {
        return findp(x) == findp(y);
    }
};
