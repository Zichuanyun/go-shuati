class Solution(object):
    def findCircleNum(self, M):
        """
        :type M: List[List[int]]
        :rtype: int
        """
        seen = {}
        n = len(M)
        ans = 0
        for i in range(n):
            stack = [i]
            newCircle = False
            while stack:
                Alice = stack.pop()
                if Alice in seen:
                    continue
                    
                seen[Alice] = True
                newCircle = True
                for j in range(n):
                    if M[Alice][j]:
                        stack += [j]
        
            if newCircle:
                ans += 1
                    
        return ans