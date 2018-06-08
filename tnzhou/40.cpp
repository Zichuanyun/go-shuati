class Solution {
public:
    unsigned long long quickhash(vector<int> &ans_so_far) {
        static const unsigned long long aprime = 934561;
        unsigned long long res = 0;
        for (int i = 0; i < ans_so_far.size(); i++) {
            res *= aprime;
            res += ans_so_far[i];
        }
        return res;
        
    }
    void dfs(int pos, int sum_so_far, int target, 
             vector<int>& candidates, vector<vector<int>> &result, 
             vector<int> &ans_so_far, unordered_map<unsigned long long, int> &hashtable) {
        if (sum_so_far == target) {
            vector <int> temp(ans_so_far);
            sort(temp.begin(), temp.end());
            unsigned long long hashval = quickhash(temp);
            if (hashtable[hashval] == 0) {
                result.push_back(temp);
                hashtable[hashval] = 1;
            }
            return;
        }
        if (sum_so_far > target)
            return;
        for (int i = pos; i < candidates.size(); i++) {
            ans_so_far.push_back(candidates[i]);
            dfs(i + 1, sum_so_far + candidates[i], target, candidates, result, ans_so_far, hashtable);
            ans_so_far.pop_back();
        }
        
    }
    
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int>> result;
        unordered_map<unsigned long long, int> hashtable;
        vector<int> ans_so_far;
        dfs(0, 0, target, candidates, result, ans_so_far, hashtable);   
        return result;
    }
};
