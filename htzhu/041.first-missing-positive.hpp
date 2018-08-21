class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        int n = nums.size();
        for(int &x: nums) {
            if(x <= 0) x = n + 2;
        }
        for(int i = 0; i < n; i++) {
            int idx = abs(nums[i]) - 1;
            if(idx >= 0 && idx < n) {
                nums[idx] = -abs(nums[idx]);
            }
        }
        for(int i = 0; i < n; i++)
            if(nums[i] > 0) return i + 1;
        return n + 1;
    }
};
