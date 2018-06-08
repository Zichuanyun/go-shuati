class Solution {
public:
    int rob(vector<int>& nums) {
        int last_house_profit = 0;
        int second_last_profit = 0;
        int curr_profit = 0;
        int max_profit = 0;
        if (nums.size() == 0)
            return 0;
        if (nums.size() == 1) 
            return nums[0]; // if only one house, directly rob it
        for (int i = 0; i < nums.size() - 1; i++) {
            curr_profit = max(
                last_house_profit,
                second_last_profit + nums[i]
            );
            max_profit = curr_profit > max_profit ? curr_profit : max_profit;
            second_last_profit = last_house_profit;
            last_house_profit = curr_profit;
        }
        last_house_profit = 0;
        second_last_profit = 0;
        curr_profit = 0;
        for (int i = 1; i < nums.size(); i++) {
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
