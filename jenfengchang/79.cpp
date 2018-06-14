class Solution {
    bool found = false;
    vector<vector<bool>> visited;
public:
    bool exist(vector<vector<char>>& board, string word) {
        visited.resize(board.size(), vector<bool>(board[0].size(), false));
        for(int i = 0; i < board.size(); i++) {
            for(int j = 0; j < board[0].size(); j++) {
                helper(board, word, 0, i, j);
            }
        }
        return found;
    }
    void helper(vector<vector<char>>& board, string& word, int idx, int i, int j) {
        if (found || i < 0 || j < 0 || i >= board.size() || j >= board[0].size() || visited[i][j]) return;
        if (board[i][j] != word[idx]) return;
        if (idx == word.size() - 1) found = true;
        visited[i][j] = true;
        helper(board, word, idx + 1, i + 1, j);
        helper(board, word, idx + 1, i - 1, j);
        helper(board, word, idx + 1, i, j + 1);
        helper(board, word, idx + 1, i, j - 1);
        visited[i][j] = false;
    }
};
