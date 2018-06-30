class Solution(object):
    def findItinerary(self, tickets):
        """
        :type tickets: List[List[str]]
        :rtype: List[str]
        """
        map = collections.defaultdict(list)
        for t in tickets:
            map[t[0]].append((t[1],False))
        for t in map:
            map[t].sort()
        
        n = len(tickets)+1
        def dfs(now, temp):
            if len(temp) == n:
                return temp
            for i in range(len(map[now])):
                next, visited = map[now][i]
                if visited:
                    continue
                map[now][i] = (next, True)
                ret = dfs(next,temp+[next])
                if ret:
                    return ret
                map[now][i] = (next, False)

            return None
        
        return dfs("JFK",["JFK"])