# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        if not intervals:
          return []
        
        tuples = [(i.start, i) for i in intervals]
        tuples.sort()
        n = len(intervals)
        res = []
        for i in range(n):
          new = tuples[i][1]
          if i==0 or res[-1].end<new.start:
            res.append(new)
          else:
            last = res.pop()
            res.append(Interval(min(last.start,new.start), max(last.end,new.end)))
        return res