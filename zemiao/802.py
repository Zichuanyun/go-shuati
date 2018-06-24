class Solution(object):
    def eventualSafeNodes(self, graph):
        """
        :type graph: List[List[int]]
        :rtype: List[int]
        """
        ans = []
        terminal, circle = set(), set()
        visited = set()

        # visited is the path to node
        def dfs(node):
            isSafe = True
            if node in visited:
                return False
            if node in terminal:
                return True
            if node in circle:
                return False
            visited.add(node)
            for i in graph[node]:
                if i in circle or not dfs(i):
                    isSafe = False
                    break
            visited.remove(node)
            if isSafe:
                terminal.add(node)
            else:
                circle.add(node)
            return isSafe
            
        for i in range(len(graph)):
            if i in ans:
                continue
            if dfs(i):
                ans.append(i)
        
        return ans