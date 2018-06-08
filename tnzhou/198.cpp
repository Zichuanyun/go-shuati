class Solution {
public:
    int rob(vector<int>& nums) {
        int last_house_profit = 0;
        int second_last_profit = 0;
        int curr_profit = 0;
        int max_profit = 0;
        for (int i = 0; i < nums.size(); i++) {
            curr_profit = max(
                last_house_profit,
                second_last_profit + nums[i]
            );
            max_profit = curr_profit > max_profit ? curr_profit : max_profit;
            second_last_profit = last_house_profit;
            last_house_profit = curr_profit;
        }
        return max_profit;
    }
};
