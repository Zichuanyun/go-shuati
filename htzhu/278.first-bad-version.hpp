#define LL long long
// Forward declaration of isBadVersion API.
bool isBadVersion(int version);

class Solution {
public:
    int firstBadVersion(int n) {
        LL lo = 1, hi = (LL)n + 1;
        while(lo < hi) {
            LL mid = lo + (hi - lo) / 2;
            if(isBadVersion(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo <= n ? lo : 0;
    }
};
