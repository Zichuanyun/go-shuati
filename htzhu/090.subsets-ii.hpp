class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<int> path;
        vector<vector<int>> ans;
        dfs(0, nums, path, ans);
        return ans;
    }
    void dfs(int p, vector<int> &nums, vector<int> &path, vector<vector<int>> &ans) {
        int n = nums.size();
        ans.push_back(path);
        for(int i = p; i < n; i++) {
            if(i > p && nums[i] == nums[i-1]) continue;
            path.push_back(nums[i]);
            dfs(i + 1, nums, path, ans);
            path.pop_back();
        }
    }
};
