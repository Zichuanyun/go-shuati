from heapq import heappop, heappush

class Solution(object):
    def findMaximizedCapital(self, k, W, Profits, Capital):
        """
        :type k: int
        :type W: int
        :type Profits: List[int]
        :type Capital: List[int]
        :rtype: int
        """
        heap = []
        
        projects = [(Capital[i], Profits[i]) for i in range(len(Profits))]
        projects.sort()
        
        i = 0
        while i < len(projects) and W >= projects[i][0]:
            heappush(heap, -projects[i][1])
            i += 1
        
        while k > 0 and heap:
            W += -heappop(heap)
            k -= 1
            while i < len(projects) and W >= projects[i][0]:
                heappush(heap, -projects[i][1])
                i += 1

        return W