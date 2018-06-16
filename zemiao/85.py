class Solution(object):
    def maximalRectangle(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if len(matrix) == 0:
            return 0
        n = len(matrix[0])
        
        # left[current] is the longest continuous [up>=up[current]] from current's left
        # right[current] is the longest continuous [up>=up[current]] from current's right
        up, left, right = [0]*n, [0]*n, [0]*n
        ans = 0
        
        # for each layer, scan left to right for [left],
        # then scan right to left for [right]
        # [left+right-1] is the final length that combined with [up] is the area
        for layer in matrix:
            continuous = 0
            for i in range(n):
                if layer[i] == "0":
                    continuous = 0
                    up[i], left[i] = 0, 0
                else:
                    continuous += 1
                    up[i] += 1
                    if i==0 or up[i-1] < up[i]:
                        left[i] = 1
                    elif up[i]==1:
                        left[i] = continuous
                    else:
                        left[i] = min(continuous,left[i])
                    
            continuous = 0
            for i in reversed(range(n)):
                if layer[i] == "0":
                    continuous = 0
                    right[i] = 0
                else:
                    continuous += 1
                    if i==n-1 or up[i+1] < up[i]:
                        right[i] = 1
                    elif up[i]==1:
                        right[i] = continuous
                    else:
                        right[i] = min(continuous,right[i])
                ans = max(ans, up[i]*(left[i]+right[i]-1))
                
        return ans