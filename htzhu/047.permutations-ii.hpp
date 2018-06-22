class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        if(nums.empty()) return {};
        sort(nums.begin(), nums.end());
        int n = nums.size();
        vector<int> path(n);
        vector<bool> vis(n);
        vector<vector<int>> ans;
        dfs(0, path, nums, ans, vis);
        return ans;
    }
    void dfs(int p, vector<int> &path, vector<int> &nums, vector<vector<int>> &ans, vector<bool> &vis) {
        int n = nums.size();
        if(p == n) {
            ans.push_back(path);
            return;
        }
        for(int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i-1] && !vis[i-1] || vis[i]) continue;
            vis[i] = true;
            path[p] = nums[i];
            dfs(p + 1, path, nums, ans, vis);
            vis[i] = false;
        }
    }
};
