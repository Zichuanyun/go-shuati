class Solution(object):
    def allPathsSourceTarget(self, graph):
        """
        :type graph: List[List[int]]
        :rtype: List[List[int]]
        """
        res = []
        n = len(graph)
        
        def dfs(i, temp):
            temp += [i]
            if i == n-1:
                res.append(temp)
                return
            for j in graph[i]:
                dfs(j,list(temp))
            temp.pop()
        
        dfs(0,[])
        return res