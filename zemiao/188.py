class Solution(object):
    def maxProfit(self, k, prices):
        """
        :type k: int
        :type prices: List[int]
        :rtype: int
        """
        delta = [1 if prices[i+1]>prices[i] else 0 for i in range(len(prices)-1)]
        count = 0
        for i in range(len(delta)):
            if delta[i]==1 and (i==0 or delta[i-1]!=1):
                count += 1
        if count < k:
            # fallback to Problem - Stock II
            delta = [prices[i+1]-prices[i] if prices[i+1]>prices[i] else 0 
                     for i in range(len(prices)-1)]
            return sum(delta)
            
        if k == 0:
            return 0
        
        hold = [-32768 for i in range(k)]
        release = [-32768 for i in range(k)]
        for price in prices:
            for i in reversed(range(k)):
                release[i] = max(release[i], hold[i]+price)
                hold[i] = max(hold[i], release[i-1]-price if i>0 else -price)
        
        return max(release + [0])
            