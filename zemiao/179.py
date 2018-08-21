class Solution(object):
    def largestNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: str
        """
        s = []
        for i in nums:
          s.append(str(i))
        
        def f(a,b):
          if a+b>b+a:
            return -1
          elif a+b==b+a:
            return 0
          else:
            return 1
        
        s.sort(cmp=f)
        res = ""
        for c in s:
          res = res + c
        return str(int(res))