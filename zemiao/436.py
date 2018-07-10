# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def findRightInterval(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[int]
        """
        s = []
        for i in range(len(intervals)):
            s.append((intervals[i].start, i))
        s.sort()
        
        def binary(end):
            l,r = 0,len(s)-1
            while l<r:
                mid = l+(r-l)/2
                if s[mid][0] >= end:
                    r = mid
                else:
                    l = mid+1
            return l
        
        res = []
        for i in intervals:
            l = binary(i.end)
            if s[l][0] >= i.end:
                res.append(s[l][1])
            else:
                res.append(-1)
        return res