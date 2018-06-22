struct Node {
    bool isEnd = false;
    vector<Node*> next = decltype(next)(26, NULL);
};

class Trie {
public:
    Node *root = new Node();
    void insert(const string &s) {
        auto p = root;
        for(auto c: s) {
            auto &q = p->next[c - 'a'];
            if(!q) q = new Node();
            p = q;
        }
        p->isEnd = true;
    }
};

class Solution {
    const int dirs[4][2] = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
public:
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        if(board.empty() || board[0].empty()) return {};
        int m = board.size(), n = board[0].size();
        Trie trie;
        for(auto &word: words) {
            trie.insert(word);
        }
        vector<string> ans;
        string path;
        vector<vector<bool>> vis(m, decltype(vis)::value_type(n));
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                dfs(i, j, board, trie.root, path, vis, ans);
        return ans;
    }
    void dfs(int r, int c, vector<vector<char>> &board, Node *node, string &path,
             vector<vector<bool>> &vis, vector<string> &ans) {
        int m = board.size(), n = board[0].size();
        node = node->next[board[r][c] - 'a'];
        if(!node) return;
        vis[r][c] = true;
        path.push_back(board[r][c]);
        if(node->isEnd) {
            ans.push_back(path);
            node->isEnd = false;
        }

        for(auto dir: dirs) {
            int x = r + dir[0], y = c + dir[1];
            if(x >= 0 && x < m && y >= 0 && y < n && !vis[x][y]) {
                dfs(x, y, board, node, path, vis, ans);
            }
        }
        vis[r][c] = false;
        path.pop_back();
    }
};
