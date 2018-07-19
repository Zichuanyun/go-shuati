class Solution {
public:
    int maxSubArrayLen(vector<int>& nums, int k) {
        int sum = 0;
        unordered_map<int, int> mp;
        int ans = 0;
        for(int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            if(sum == k) ans = max(ans, i + 1);
            else if(mp.count(sum - k)) ans = max(ans, i - mp[sum - k]);
            if(!mp.count(sum)) mp[sum] = i;
        }
        return ans;
    }
};
