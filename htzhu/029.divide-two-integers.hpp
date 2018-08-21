#define LL long long

class Solution {
public:
    int divide(int dividend, int divisor) {
        if(divisor == 0 || dividend == INT_MIN && divisor == -1) return INT_MAX;
        LL dvd = labs(dividend), dvs = labs(divisor);
        int ans = 0;
        while(dvd >= dvs) {
            LL acc = dvs, cnt = 1;
            while((acc << 1) <= dvd) {
                acc <<= 1;
                cnt += cnt;
            }
            dvd -= acc;
            ans += cnt;
        }
        return ((dividend ^ divisor) < 0) ? -ans : ans;
    }
};
