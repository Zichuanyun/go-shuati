class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        hold1, hold2, sell1, sell2 = -32768,-32768,-32768,-32768
        for p in prices:
            sell2 = max(sell2,hold2+p)
            hold2 = max(hold2,sell1-p)
            sell1 = max(sell1,hold1+p)
            hold1 = max(hold1,-p)
        
        return max(sell1,sell2,0)