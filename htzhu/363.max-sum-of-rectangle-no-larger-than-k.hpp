class Solution {
public:
    int maxSumSubmatrix(vector<vector<int>>& matrix, int k) {
        int m = matrix.size(), n = matrix[0].size();
        int ans = INT_MIN;
        for(int l = 0; l < m; l++) {
            vector<int> sum(n);
            for(int r = l; r < m; r++) {
                for(int i = 0; i < n; i++) sum[i] += matrix[r][i];
                set<int> st;
                st.insert(0);
                int acc = 0;
                for(int val: sum) {
                    acc += val;
                    auto it = st.lower_bound(acc - k);
                    if(it != st.end()) {
                        ans = max(ans, acc - *it);
                    }
                    st.insert(acc);
                }
            }
        }
        return ans;
    }
};
