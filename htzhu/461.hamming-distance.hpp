class Solution {
public:
    int hammingDistance(int x, int y) {
        int diff = x ^ y;
        int ans = 0;
        while(diff) {
            diff &= diff - 1;
            ans++;
        }
        return ans;
    }
};
