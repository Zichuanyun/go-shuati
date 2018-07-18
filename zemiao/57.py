# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[Interval]
        :type newInterval: Interval
        :rtype: List[Interval]
        """
        res = []
        newV = newInterval
        inserted = False
        for v in intervals:
          if inserted or v.end < newV.start:
            res.append(v)
          elif v.start > newV.end:
            res.append(newV)
            res.append(v)
            inserted = True
          else:
            newV = Interval(min(v.start,newV.start),max(v.end,newV.end))
        if not inserted:
          res.append(newV)
        return res