class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        int n = nums.size();
        vector<int> path(n);
        vector<bool> vis(n);
        vector<vector<int>> ans;
        dfs(nums, path, 0, ans, vis);
        return ans;
    }
    void dfs(vector<int> &nums, vector<int> &path, int sz, vector<vector<int>> &ans, vector<bool> &vis) {
        int n = nums.size();
        if(sz == n) {
            ans.push_back(path);
            return;
        }
        for(int i = 0; i < n; i++) {
            if(vis[i]) continue;
            vis[i] = true;
            path[sz] = nums[i];
            dfs(nums, path, sz + 1, ans, vis);
            vis[i] = false;
        }
    }
};
