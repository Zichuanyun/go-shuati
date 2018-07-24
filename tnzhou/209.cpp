class Solution {
public:
    int minSubArrayLen(int s, vector<int>& nums) {
        int leftlimit = 0;
        int curTotal = 0;
        int minLength = nums.size() + 1;
        
        for (int i = 0; i < nums.size(); i ++) {
            curTotal += nums[i];
            while (curTotal - nums[leftlimit] >= s) {
                curTotal -= nums[leftlimit];
                leftlimit ++;
            }
            if (curTotal >= s && i - leftlimit + 1 < minLength) {
                minLength = i - leftlimit + 1;
            }
        }
        
        return minLength > nums.size() ? 0 : minLength;
    }
};
