class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if len(prices) < 2:
            return 0
        
        lowest, maxGain = prices[0], 0
        for price in prices:
            lowest = min(lowest, price)
            maxGain = max(maxGain, price-lowest)
        
        return maxGain