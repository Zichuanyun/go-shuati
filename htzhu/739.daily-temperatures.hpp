class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int n = temperatures.size();
        vector<int> ans(n);
        stack<int> stk;
        for(int i = n - 1; i >= 0; i--) {
            while(!stk.empty() && temperatures[stk.top()] <= temperatures[i]) {
                stk.pop();
            }
            ans[i] = (stk.empty() ? 0 : stk.top() - i);
            stk.push(i);
        }
        return ans;
    }
};
