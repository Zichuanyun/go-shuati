class Solution {
public:
    int findMaximizedCapital(int k, int W, vector<int>& Profits, vector<int>& Capital) {
        auto cmpCap = [&Capital](int lhs, int rhs) { return Capital[lhs] > Capital[rhs]; };
        auto cmpPro = [&Profits](int lhs, int rhs) { return Profits[lhs] < Profits[rhs]; };
        priority_queue<int, vector<int>, decltype(cmpCap)> pqCap(cmpCap);
        priority_queue<int, vector<int>, decltype(cmpPro)> pqPro(cmpPro);

        for(int i = 0; i < Profits.size(); i++)
            pqCap.push(i);

        int ans = W;
        while(k--) {
            while(!pqCap.empty() && Capital[pqCap.top()] <= ans) {
                int id = pqCap.top(); pqCap.pop();
                pqPro.push(id);
            }
            if(pqPro.empty()) break;
            ans += Profits[pqPro.top()];
            pqPro.pop();
        }
        return ans;
    }
};
