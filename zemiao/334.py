class Solution(object):
    def increasingTriplet(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        a,b = None,None
        for x in nums:
          if a==None or x<=a:
            a = x
            continue
          if b==None or x<=b:
            b = x
            continue
          return True
        return False