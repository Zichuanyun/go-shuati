from collections import deque, defaultdict

class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        res = []
        if not num:
          return res
        
        n = len(num)
        def dfs(begin,tmp,val,mul):
          if begin==n:
            if val==target:
              res.append(tmp)
            return
          
          for i in range(begin,n):
            if num[begin]=='0' and i>begin:
              # If next number is '0*', discard
              break
            
            x = int(num[begin:i+1])
            if begin==0:
              dfs(i+1,tmp+num[:i+1],x,x)
              continue
            dfs(i+1,tmp+'+'+num[begin:i+1],val+x,x)
            dfs(i+1,tmp+'-'+num[begin:i+1],val-x,-x)
            dfs(i+1,tmp+'*'+num[begin:i+1],val-mul+mul*x,mul*x)
        
        dfs(0,"",0,0)
        return res