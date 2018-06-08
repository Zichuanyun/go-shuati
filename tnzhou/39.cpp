class Solution {
public:
    void dfs(int pos, int sum_so_far, int target, 
             vector<int>& candidates, vector<vector<int>> &result, vector<int> &ans_so_far) {
        if (sum_so_far == target) {
            vector <int> temp(ans_so_far);
            result.push_back(temp);
        }
        if (sum_so_far > target)
            return;
        for (int i = pos; i < candidates.size(); i++) {
            ans_so_far.push_back(candidates[i]);
            dfs(i, sum_so_far + candidates[i], target, candidates, result, ans_so_far);
            ans_so_far.pop_back();
        }
        
    }
    
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> result;
        vector<int> ans_so_far;
        dfs(0, 0, target, candidates, result, ans_so_far);
        return result;
    }
};
