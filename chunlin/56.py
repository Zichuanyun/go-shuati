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
        result = list()
        for interval in sorted(intervals, key=lambda i: i.start):
            if result and result[-1].end >= interval.start:
                result[-1].end = max(result[-1].end, interval.end)  # result[-1].end = interval.end
            else:
                result.append(interval)
        return result

    
    # WA: [[1,4],[2,3]] -> Output:[[1,3]] Expected:[[1,4]]
