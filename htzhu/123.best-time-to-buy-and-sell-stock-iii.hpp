class Solution {
public:
    int maxProfit(vector<int>& prices) {
      int K = 2;
      int n = prices.size();
      if(n < 2) return 0;
      vector<vector<int>> f(K + 1, vector<int>(n));
      for(int k = 1; k <= 2; k++) {
        int localMax = -prices[0];
        for(int i = 1; i < n; i++) {
          f[k][i] = max(f[k][i-1], prices[i] + localMax);
          localMax = max(localMax, f[k-1][i] - prices[i]);
        }
      }
      return f[K][n-1];
    }
};
