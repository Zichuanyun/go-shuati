class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n = citations.size();
        vector<int> cnt(n+1);
        for(int x: citations)
            cnt[x < n ? x : n]++;
        int sum = 0, ans = 0;
        for(int i = n; i >= 0; i--) {
            sum += cnt[i];
            ans = max(ans, min(i, sum));
        }
        return ans;
    }
};
