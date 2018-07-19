class Solution {
public:
    int mySqrt(int x) {
        long lo = 0, hi = x / 2;
        while(lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long diff = mid * mid - x;
            if(diff == 0) return mid;
            else if(diff > 0) {
                hi = mid - 1;
            } else if((mid + 1) * (mid + 1) > x) {
                return mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
};
