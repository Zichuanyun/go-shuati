class Solution {
public:
    int rob(vector<int>& nums) {
        int toRob, notRob;
        toRob = notRob = 0;
        for(int x: nums) {
            int tmp = toRob;
            toRob = x + notRob;
            notRob = max(tmp, notRob);
        }
        return max(toRob, notRob);
    }
};
