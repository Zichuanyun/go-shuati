class Solution(object):
    def findMinHeightTrees(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        # map{(root, cut)}
        edge = collections.defaultdict(set)
        for e in edges:
            edge[e[0]].add(e[1])
            edge[e[1]].add(e[0])

        map = {}
        minH = 2**31
        ans = []
        
        def findCutHeight(root, cut):
            if (root,cut) in map:
                return map[(root,cut)]
            
            edge[root].discard(cut)
            
            h = 1
            for node in edge[root]:
                h = max(findCutHeight(node, root)+1,h)
               
            map[(root,cut)] = h
            if root != cut:
                edge[root].add(cut)
            return h
        
        for root in edge:
            h = findCutHeight(root, root)
            if h < minH:
                ans = [root]
                minH = h
            elif h == minH:
                ans += [root]
                            
        return ans if ans else [0]