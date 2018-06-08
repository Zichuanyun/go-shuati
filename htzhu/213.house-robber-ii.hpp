class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        return max(robAcyclic(0, n - 1, nums), robAcyclic(1, n - 1, nums));
    }
    int robAcyclic(int from, int len, vector<int> &nums) {
        int toRob, notRob;
        toRob = notRob = 0;
        for(int i = 0; i < len; i++) {
            int j = (from + i) % nums.size();
            int tmp = toRob;
            toRob = nums[j] + notRob;
            notRob = max(notRob, tmp);
        }
        return max(toRob, notRob);
    }
};
