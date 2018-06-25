class Solution {
public:
    int totalNQueens(int n) {
        vector<bool> col(n), diag(2 * n - 1), antiDiag(2 * n - 1);
        int ans = 0;
        dfs(0, n, col, diag, antiDiag, ans);
        return ans;
    }
    void dfs(int r, int n, vector<bool> &col, vector<bool> &diag, vector<bool> &adiag, int &ans) {
        if(r == n) {
            ans++;
            return;
        }
        for(int c = 0; c < n; c++) {
            int diagIndex = c - r + n - 1, adiagIndex = c + r;
            if(col[c] || diag[diagIndex] || adiag[adiagIndex]) continue;
            col[c] = diag[diagIndex] = adiag[adiagIndex] = true;
            dfs(r + 1, n, col, diag, adiag, ans);
            col[c] = diag[diagIndex] = adiag[adiagIndex] = false;
        }
    }
};
