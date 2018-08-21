class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
        n = len(gas)
        i = 0
        while i<n:
            j,tempSum = 0,0
            while j<=n:
                if j == n:
                    return i
                
                next = (i+j)%n
                tempSum += gas[next]-cost[next]
                if tempSum < 0:
                    # The reason we can jump over to next of next:
                    # netIncrease[i:next] is always first pos then neg.
                    i = i+j+1
                    break
                    
                j += 1

        return -1
        