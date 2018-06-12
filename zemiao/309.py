class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        hold = -32768
        release = [-32768, -32768]
        for i in range(len(prices)):
            price = prices[i]
            newRelease = max(release[-1], hold+price, 0)
            hold = max(hold, release[-2]-price if i-2 >= 0 else -price)
            release = [release[-1], newRelease]
            
        return max(release + [0])