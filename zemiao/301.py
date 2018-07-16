class Solution(object):
    def removeInvalidParentheses(self, s):
      """
      :type s: str
      :rtype: List[str]
      """
      def remove(s, reverse):
        if reverse:
          s = s[::-1]
        res = [""]
        left, right, temp = 0, 0, ""
        lp = '(' if not reverse else ')'
        rp = ')' if not reverse else '('
        for c in s:
          temp = temp+c
          if c==lp:
            left += 1
          elif c==rp:
            right += 1
          if left < right:
            res = [r+temp for r in res]
            
            newRes = set()
            for temp in res:
              for i in range(len(temp)):
                if temp[i] == rp and (i==0 or temp[i-1]!=rp):
                  newRes.add(temp[:i]+temp[i+1:])
            res = list(newRes)
            left, right, temp = 0,0,""

        if res:
          for i in range(len(res)):
            res[i] = res[i] + str(temp)
        else:
          res = [temp]
        return [r[::-1] for r in res] if reverse else res

      resL = remove(s, False)
      res = []
      for r in resL:
        res.extend(remove(r,True))
      return res