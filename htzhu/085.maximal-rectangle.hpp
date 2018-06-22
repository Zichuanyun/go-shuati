class Solution {
public:
    int maximalRectangle(vector<vector<char>>& matrix) {
        if(matrix.empty() || matrix[0].empty()) return 0;
        int m = matrix.size(), n = matrix[0].size();
        vector<int> sum(n);
        int ans = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') {
                    sum[j] = 1 + (i > 0 && matrix[i-1][j] == '1' ? sum[j] : 0);
                } else {
                    sum[j] = 0;
                }
            }
            ans = max(ans, maxArea(sum));
        }
        return ans;
    }
    int maxArea(vector<int> &H) {
        stack<int> stk;
        int n = H.size();
        int ans = 0;
        for(int i = 0; i <= n; i++) {
            int cur = (i == n ? -1 : H[i]);
            while(!stk.empty() && cur <= H[stk.top()]) {
                int h = H[stk.top()]; stk.pop();
                int j = stk.empty() ? 0 : stk.top() + 1;
                ans = max(ans, h * (i - j));
            }
            stk.push(i);
        }
        return ans;
    }
};
