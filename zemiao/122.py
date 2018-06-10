class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        gain = 0
        for i in range(1,len(prices)):
            delta = prices[i]-prices[i-1]
            gain += delta if delta > 0 else 0
            
        return gain