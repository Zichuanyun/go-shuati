class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int n = nums.size();
        vector<vector<int>> ans;
        for(int i = 0; i < n - 1; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i + 1, k = n - 1; j < k;) {
                if(j > i + 1 && nums[j] == nums[j-1]) {
                    j++;
                    continue;
                }
                if(k < n - 1 && nums[k] == nums[k+1]) {
                    k--;
                    continue;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    ans.push_back({nums[i], nums[j], nums[k]});
                    j++;
                    k--;
                } else if(sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }
};
