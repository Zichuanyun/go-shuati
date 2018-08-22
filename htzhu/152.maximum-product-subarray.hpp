class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int n = nums.size();
        if(n == 1) return nums[0];
        int max_val, min_val;
        max_val = min_val = nums[0];
        int ans = max_val;
        for(int i = 1; i < n; i++) {
            int v = nums[i];
            if(v >= 0) {
                max_val = max(v, max_val * v);
                min_val = min(v, min_val * v);
            } else {
                int tmp = max_val;
                max_val = max(v, min_val * v);
                min_val = min(v, tmp * v);
            }
            ans = max(ans, max_val);
        }
        return ans;
    }
};
