class Solution {
public:
    bool increasingTriplet(vector<int>& nums) {
        int m1, m2;
        m1 = m2 = INT_MAX;
        for(int x: nums) {
            if(x <= m1) {
                m1 = x;
            } else if(x <= m2) {
                m2 = x;
            } else {
                return true;
            }
        }
        return false;
    }
};
