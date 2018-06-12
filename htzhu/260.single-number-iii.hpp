class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        int AxorB = 0;
        for(int x: nums)
            AxorB ^= x;
        AxorB &= -AxorB;
        vector<int> ans = {0, 0};
        for(int x: nums) {
            if(x & AxorB) {
                ans[0] ^= x;
            } else {
                ans[1] ^= x;
            }
        }
        return ans;
    }
};
