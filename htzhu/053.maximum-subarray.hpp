class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int n = nums.size();
        int ans = INT_MIN, sum = 0;
        for(int x: nums) {
            sum += x;
            ans = max(sum, ans);
            if(sum < 0) sum = 0;
        }
        return ans;
    }
};
