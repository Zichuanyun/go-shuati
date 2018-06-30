class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        # calculate [maxTrapLen]
        def getMaxTrapLen(beg, end, maxTrapLen, step):
            lastHighest, lastHighestIndex = 0, -1
            i = beg
            while i != end:
                if height[i] < lastHighest:
                    maxTrapLen[lastHighestIndex] += 1
                    maxTrapLen[i] = -1
                elif height[i] == lastHighest:
                    lastHighestIndex = i
                else:
                    lastHighest, lastHighestIndex = height[i], i
                i += step
            return lastHighestIndex
            
        n = len(height)
        trap1, trap2 = [0]*n, [0]*n
        
        # from left to right
        highestIndex = getMaxTrapLen(0, n, trap1, 1)
        
        # from right to left
        getMaxTrapLen(n-1, highestIndex, trap2, -1)
        
        # iterate, +/- res according to maxTrapLen
        res = 0
        for i in range(0, n):
            if i == highestIndex:
                continue
            if trap1[i] > 0:
                res += trap1[i]*height[i]
            elif trap2[i] > 0:
                res += trap2[i]*height[i]
            elif i < highestIndex:
                res -= height[i] if trap1[i] == -1 else 0
            else:
                res -= height[i] if trap2[i] == -1 else 0
                
        return res