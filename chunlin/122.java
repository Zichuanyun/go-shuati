class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int i = 0;
        int profit = 0; 
        int valley = prices[0]; // = 0
        int peak = prices[0]; // = 0
        while (i < prices.length - 1) {    // i <= 
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) i++;   
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) i++;
            peak = prices[i];
            profit += peak - valley;
        }
        return profit;
    }
}
// 基本是抄答案了…… Solution 2
// 值得注意的是结束条件 该解包含了分情况讨论的多种条件
// 比如倒数第二个是peak 最后一个小于peak的情况 这时valley前的while会跳出 使valley == peak
// 最后使profit += 0
