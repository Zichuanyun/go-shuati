class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n = citations.size();
        if(n == 0) return 0;
        int lo = 0, hi = n - 1;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(citations[mid] >= n - mid) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return citations[hi] >= n - hi ? n - hi : 0;
    }
};
