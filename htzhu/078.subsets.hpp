class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> path;
        dfs(0, nums, path, ans);
        return ans;
    }
    void dfs(int p, vector<int> &nums, vector<int> &path, vector<vector<int>> &ans) {
        int n = nums.size();
        if(p == n) {
            ans.push_back(path);
            return;
        }
        path.push_back(nums[p]);
        dfs(p + 1, nums, path, ans);
        path.pop_back();
        dfs(p + 1, nums, path,ans);
    }
};
