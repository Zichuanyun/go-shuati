class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_map<int, int> mp;
        int ans = 0;
        for(int x: nums) {
            if(mp.count(x)) continue;
            int lLen = mp.count(x - 1) ? mp[x-1] : 0, rLen = mp.count(x + 1) ? mp[x+1] : 0;
            int len = mp[x] = mp[x - lLen] = mp[x + rLen] = 1 + lLen + rLen;
            ans = max(ans, len);
        }
        return ans;
    }
};
