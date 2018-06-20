class Solution(object):
    def findCheapestPrice(self, n, flights, src, dst, K):
        """
        :type n: int
        :type flights: List[List[int]]
        :type src: int
        :type dst: int
        :type K: int
        :rtype: int
        """
        # pragma mark - Dijkstra with heapq
        
        map = collections.defaultdict(dict)
        for a,b,cost in flights:
            map[a][b] = cost 
        heap = [(0, src, K)]
        while heap:
            cost, current, k = heapq.heappop(heap)
            if current == dst:
                return cost
            if k >= 0:
                for next in map[current]:
                    heapq.heappush(heap, (cost+map[current][next], next, k-1))
            
        return -1
        
        
        # pragma mark - DFS/DP with memory

        # from collections import defaultdict
        # map = defaultdict(dict)
        # cache = {}
        # for a,b,cost in flights:
        #     map[a][b] = cost

        # def dfs(src, dest, k):
        #     if src == dest:
        #         return 0
        #     if k == 0:
        #         return -1 if dest not in map[src] else map[src][dest]
        #     ans = -1
        #     for next in map[src]:
        #         if (next,dest,k-1) not in cache:
        #             cache[next,dest,k-1] = dfs(next,dest,k-1)
        #         temp = cache[next,dest,k-1]
        #         if temp >= 0:
        #             ans = min(ans, map[src][next] + temp) if ans >= 0 else map[src][next] + temp
        #     return ans

        # return dfs(src, dst, K)