class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        int n = wordList.size() + 1;
        int src = 0, dst = -1;
        vector<vector<int>> cnts(n, vector<int>(26)), adj(n);
        for(int i = 0; i < n; i++) {
            auto &from = (i == 0 ? beginWord : wordList[i-1]);
            if(from == endWord) dst = i;
            for(int j = i + 1; j < n; j++) {
                auto &to = wordList[j-1];
                if(hasPath(from, to)) {
                    adj[i].push_back(j);
                    adj[j].push_back(i);
                }
            }
        }
        if(dst == -1) return 0;

        vector<bool> vis(n);
        vector<int> lvl, tlvl;
        int d = 1;
        lvl.push_back(src);
        vis[src] = true;

        while(!lvl.empty()) {
            d++;
            tlvl.clear();
            for(int p: lvl) {
                for(int q: adj[p]) {
                    if(q == dst) return d;
                    if(vis[q]) continue;
                    vis[q] = true;
                    tlvl.push_back(q);
                }
            }
            lvl.swap(tlvl);
        }
        return 0;
    }
    bool hasPath(const string &s, const string &t) {
        int m = s.size(), n = t.size();
        if(m != n) return false;
        for(int i = 0; i < m; i++) {
            if(s[i] != t[i]) {
                int j = i + 1;
                while(j < n && s[j] == t[j]) j++;
                return j == n;
            }
        }
        return false;
    }
};
