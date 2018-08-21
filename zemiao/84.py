class Solution(object):
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        if not heights:
            return 0
        n = len(heights)
        ltor,rtol = [0]*n,[1]*n
        ltor[0]=1
        rtol[-1]=1
        
        for i in range(1,n):
            j = i-1
            while j >= 0 and heights[j]>heights[i]:
                j -= ltor[j]
            if j >= 0 and heights[j]==heights[i]:
                ltor[i] = i-j+ltor[j]
            else:
                ltor[i] = i-j
            
        for i in reversed(range(0,n-1)):
            j = i+1
            while j < n and heights[j]>heights[i]:
                j += rtol[j]
            if j < n and heights[j]==heights[i]:
                rtol[i] = j-i+rtol[j]
            else:
                rtol[i] = j-i
        
        res = 0
        for i in range(len(heights)):
            res = max(res, heights[i]*(ltor[i]+rtol[i]-1))
        return res