class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int n = nums.size();
        int i = n - 2;
        while(i >= 0 && nums[i] >= nums[i+1]) i--;
        reverse(nums.begin() + i + 1, nums.end());
        if(i >= 0) {
            auto it = upper_bound(nums.begin() + i + 1, nums.end(), nums[i]);
            swap(*(nums.begin() + i), *it);
        }
    }
};
