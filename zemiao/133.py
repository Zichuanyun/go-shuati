# Definition for a undirected graph node
# class UndirectedGraphNode:
#     def __init__(self, x):
#         self.label = x
#         self.neighbors = []

class Solution:
    # @param node, a undirected graph node
    # @return a undirected graph node
    def cloneGraph(self, node):
        if not node:
            return None
        
        seen = {}
        stack = [node]
        while stack:
            # bfs
            temp = stack.pop(0)
            # dfs
            # temp = stack.pop()

            if not temp.label in seen:
                seen[temp.label] = UndirectedGraphNode(temp.label)
            
            for i in temp.neighbors:
                if not i.label in seen:
                    stack += [i]
                    _new = UndirectedGraphNode(i.label)
                    seen[i.label] = _new
                    
                seen[temp.label].neighbors.append(seen[i.label])
                        
        return seen[node.label]