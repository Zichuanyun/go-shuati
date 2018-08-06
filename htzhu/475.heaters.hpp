class Solution {
public:
    int findRadius(vector<int>& houses, vector<int>& heaters) {
        sort(heaters.begin(), heaters.end());
        int ans = 0;
        for(int h: houses) {
            auto it = upper_bound(heaters.begin(), heaters.end(), h);
            int left = (it == heaters.begin() ? INT_MAX : h - *(it - 1));
            int right = (it == heaters.end() ? INT_MAX : *it - h);
            ans = max(ans, min(left, right));
        }
        return ans;
    }
};
