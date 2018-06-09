class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<vector<int>> ans;
        vector<int> path;
        dfs(0, candidates, path, target, ans);
        return ans;
    }
    void dfs(int p, vector<int> &nums, vector<int> &path, int target, vector<vector<int>> &ans) {
        if(target <= 0) {
            if(target == 0) {
                ans.emplace_back(path);
            }
            return;
        }
        int n = nums.size();
        if(p == n) return;
        for(int i = p; i < n; i++) {
            if(i != p && nums[i] == nums[i-1]) continue;
            path.push_back(nums[i]);
            dfs(i + 1, nums, path, target - nums[i], ans);
            path.pop_back();
        }
    }
};
