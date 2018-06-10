class Solution(object):
    def maxProfit(self, prices, fee):
        """
        :type prices: List[int]
        :type fee: int
        :rtype: int
        """
        hold, release = -327680, -327680
        for price in prices:
            newRelease = max(release, hold+price-fee)
            hold = max(hold, release-price if release >=0 else -price)
            release = newRelease
            
        return max(release, 0)
        