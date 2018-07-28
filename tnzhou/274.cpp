class Solution {
public:
    int hIndex(vector<int>& citations) {
        sort(citations.begin(), citations.end());
        if (citations.size() == 0)
            return 0;
        int res;
        int left = 0;
        int right = citations.size();
        while (left <= right) {
            int m = (left + right) / 2;
            if (citations[m] >= citations.size() - m) {
                res = citations.size() - m;
                right = m - 1;
            } else {
                left = m + 1 ;
            }
        }
        return res;
    }
};
