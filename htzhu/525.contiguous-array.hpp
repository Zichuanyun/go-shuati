class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        int n = nums.size();
        for(int &x: nums) x = (x == 0 ? -1 : 1);
        unordered_map<int, int> mp;
        mp[0] = -1;
        int sum = 0;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            if(mp.count(sum)) {
                ans = max(ans, i - mp[sum]);
            } else {
                mp[sum] = i;
            }
        }
        return ans;
    }
};
