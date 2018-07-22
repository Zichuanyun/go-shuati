class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        # (NOTE): dp with memory is faster, dp backwards is fastest because no recursive.
        
        # p should not start with *
        if p and p[0]=='*':
          return False
        
        m,n = len(s),len(p)
        
        def isMatch(i,j):
          if i==m and j==n:
            return True
          if i<m and j==n:
            return False
          if i==m and j<n:
            for k in range(j,n):
              if p[k]!='*' and (k+1==n or p[k+1]!='*'):
                return False
            return True
          
          if p[j]==s[i] or p[j]=='.':
            # ab vs ab
            if isMatch(i+1,j+1):
              return True
            
            # ab vs a*ab
            if j+1<n and p[j+1]=='*':
              return isMatch(i,j+2)
            return False
            
          elif p[j]=='*':
            # 0
            if isMatch(i,j+1):
              return True
            
            # 1 or more:
            if p[j-1]!=s[i] and p[j-1]!='.':
              return False
            return isMatch(i+1,j)
          
          elif j+1<n and p[j+1]=='*':
            return isMatch(i,j+1)
          else:
            return False
          
        return isMatch(0,0)