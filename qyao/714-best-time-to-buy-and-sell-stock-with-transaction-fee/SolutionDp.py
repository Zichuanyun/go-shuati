class Solution:
    def maxProfit(self, prices, fee):
        """
        :type prices: List[int]
        :type fee: int
        :rtype: int
        """
        if len(prices) < 2:
            return 0

        dp = [0] * len(prices)
        local_max_profit_minus_buying_price = dp[0] - prices[0]
        for i in range(1, len(prices)):
            local_max_profit_minus_buying_price = max(
                local_max_profit_minus_buying_price,
                dp[i - 1] - prices[i - 1]
            )
            dp[i] = max(
                dp[i - 1],
                local_max_profit_minus_buying_price + prices[i] - fee
            )

        return dp[-1]

