class Solution {
public:
    int minSubArrayLen(int s, vector<int>& nums) {
        int n = nums.size();
        int ans = n + 1;
        for(int i = 0, j = 0, sum = 0; j < n;) {
            sum += nums[j++];
            while(sum >= s) {
                ans = min(ans, j - i);
                sum -= nums[i++];
            }
        }
        return ans == n + 1 ? 0 : ans;
    }
};
