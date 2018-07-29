class Solution {
public:
    string alienOrder(vector<string>& words) {
        int n = words.size();
        unordered_map<char, unordered_set<char>> adj;
        unordered_map<char, int> degree;
        string ans;
        for(auto &word: words) {
            for(auto c: word)
                adj[c] = {};
        }
        for(int i = 0; i < n - 1; i++) {
            auto &s = words[i], &t = words[i+1];
            for(int j = 0; j < min(s.size(), t.size()); j++) {
                if(s[j] != t[j]) {
                    char from = s[j], to = t[j];
                    if(!adj[from].count(to)) {
                        adj[from].insert(to);
                        degree[to]++;
                    }
                    break;
                }
            }
        }
        queue<char> q;
        for(auto &edges: adj) {
            char node = edges.first;
            if(!degree.count(node)) {
                q.push(node);
                ans.push_back(node);
            }
        }
        while(!q.empty()) {
            char node = q.front(); q.pop();
            for(char nodeNext: adj[node]) {
                if(--degree[nodeNext] == 0) {
                    q.push(nodeNext);
                    ans.push_back(nodeNext);
                }
            }
        }
        for(auto &pr: degree) {
            if(pr.second > 0) return "";
        }
        return ans;
    }
};
