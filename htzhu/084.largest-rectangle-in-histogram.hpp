class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        stack<int> stk;
        int ans = 0;
        int n = heights.size();
        for(int i = 0; i <= n; i++) {
            int cur_h = (i == n ? -1 : heights[i]);
            while(!stk.empty() && heights[stk.top()] >= cur_h) {
                int h = heights[stk.top()];
                stk.pop();
                int w = stk.empty() ? i : (i - 1 - stk.top());
                ans = max(ans, h * w);
            }
            stk.push(i);
        }
        return ans;
    }
};
