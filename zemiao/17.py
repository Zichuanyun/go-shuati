class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        if not digits:
          return []
        
        l = ["abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"]
        res = [""]
        for d in digits:
          newRes = []
          while res:
            s = res.pop()
            for c in l[ord(d)-ord('2')]:
              newRes.append(s+c)
          res = newRes
        return res