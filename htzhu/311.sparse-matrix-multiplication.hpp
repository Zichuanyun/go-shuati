class Solution {
public:
    vector<vector<int>> multiply(vector<vector<int>>& A, vector<vector<int>>& B) {
        if(A.empty() || A[0].empty()) return {};
        int m = A.size(), n = A[0].size(), nb = B[0].size();
        vector<vector<int>> ans(m, vector<int>(nb));
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(A[i][j]) {
                    for(int k = 0; k < nb; k++) {
                        if(B[j][k]) {
                            ans[i][k] += A[i][j] * B[j][k];
                        }
                    }
                }
            }
        }
        return ans;
    }
};
