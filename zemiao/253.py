"""
Definition of Interval.
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""
import heapq
class Solution:
    """
    @param intervals: an array of meeting time intervals
    @return: the minimum number of conference rooms required
    """
    def minMeetingRooms(self, intervals):
        # Write your code here
        heap = []
        intervals.sort(key=lambda x:x.start)
        for x in intervals:
          if heap and heap[0][1].end <= x.start:
            heap[0] = (x.end, x)
            heapq.heapify(heap)
            continue
          
          heapq.heappush(heap,(x.end, x))
        return len(heap)