class Solution {
    vector<int> uf;
    vector<int> sz;
public:
    vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
        int n = accounts.size();
        uf = sz = vector<int>(n, 1);
        iota(uf.begin(), uf.end(), 0);

        unordered_map<string, vector<int>> revIndex;
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < accounts[i].size(); j++) {
                revIndex[accounts[i][j]].push_back(i);
            }
        }
        for(auto &emailIdsPr: revIndex) {
            auto &ids = emailIdsPr.second;
            for(int i = 0; i < ids.size() - 1; i++) {
                connect(ids[i], ids[i+1]);
            }
        }
        unordered_map<int, unordered_set<string>> idToEmails;
        for(int i = 0; i < n; i++) {
            int pid = findp(i);
            idToEmails[pid].insert(accounts[i].begin() + 1, accounts[i].end());
        }
        vector<vector<string>> ans(idToEmails.size());
        auto it = ans.begin();
        for(auto &idEmailsPr: idToEmails) {
            auto id = idEmailsPr.first;
            auto &emails = idEmailsPr.second;
            it->push_back(accounts[id][0]);
            it->insert(it->begin() + 1, emails.begin(), emails.end());
            sort(it->begin() + 1, it->end());
            it++;
        }
        return ans;
    }
    int findp(int x) {
        return uf[x] == x ? x : uf[x] = findp(uf[x]);
    }
    void connect(int x, int y) {
        int p = findp(x), q = findp(y);
        if(p == q) return;
        if(sz[p] < sz[q]) swap(p, q);
        uf[q] = p;
        sz[p] += sz[q];
    }
};
