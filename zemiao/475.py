class Solution(object):
    def findRadius(self, houses, heaters):
        """
        :type houses: List[int]
        :type heaters: List[int]
        :rtype: int
        """
        
        # Returns index of rightmost heater to the left of x
        heaters.sort()
        def binarySearch(x):
          l,r = 0, len(heaters)-1
          while l<=r:
            mid = l+(r-l)/2
            if heaters[mid]<x:
              l = mid+1
            elif heaters[mid]>x:
              r = mid-1
            else:
              return mid
          return l-1
        
        res = 0
        n = len(houses)
        for i in range(n):
          h = binarySearch(houses[i])
          if heaters[h]==houses[i]:
            continue
          if h == -1:
            res = max(res,heaters[h+1]-houses[i])
          elif h == len(heaters)-1:
            res = max(res,houses[i]-heaters[h])
          else:
            res = max(res,min(houses[i]-heaters[h],heaters[h+1]-houses[i]))
        return res