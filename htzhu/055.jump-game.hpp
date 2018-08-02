class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n = nums.size();
        int maxr = 0;
        for(int i = 0; i < n - 1; i++) {
            if(i > maxr) continue;
            maxr = max(maxr, i + nums[i]);
        }
        return maxr >= n - 1;
    }
};
