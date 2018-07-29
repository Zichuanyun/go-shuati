class Solution {
public:
    vector<pair<int, int>> getSkyline(vector<vector<int>>& buildings) {
        if(buildings.empty()) return {};
        return helper(0, buildings.size() - 1, buildings);
    }
    vector<pair<int, int>> helper(int lo, int hi, vector<vector<int>> &A) {
        if(lo == hi) return {{A[lo][0], A[lo][2]}, {A[lo][1], 0}};
        int mid = lo + (hi - lo) / 2;
        auto left = helper(lo, mid, A);
        auto right = helper(mid + 1, hi, A);
        return merge(left, right);
    }
    vector<pair<int, int>> merge(vector<pair<int, int>> &l, vector<pair<int, int>> &r) {
        int m = l.size(), n = r.size();
        int curH = 0;
        vector<pair<int, int>> res;
        for(int i = 0, j = 0, hl = 0, hr = 0; i < m || j < n;) {
            int k;
            if(i < m && j < n && l[i].first == r[j].first) {
                hl = l[i].second;
                hr = r[j].second;
                k = l[i].first;
                i++;
                j++;
            } else if(j == n || i < m && (l[i].first < r[j].first)) {
                hl = l[i].second;
                k = l[i].first;
                i++;
            } else{
                hr = r[j].second;
                k = r[j].first;
                j++;
            }
            int h = max(hl, hr);
            if(h != curH) {
                res.emplace_back(k, h);
                curH = h;
            }
        }
        return res;
    }
};
