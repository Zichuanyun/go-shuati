class Solution {
public:
    int threeSumSmaller(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        int ans = 0;
        int n = nums.size();
        for(int i = 0; i < n - 2; i++) {
            for(int j = i + 1, k = n - 1; j < k;) {
                if(nums[i] + nums[j] + nums[k] < target) {
                    ans += k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }
};
