class Solution(object):
    def isBipartite(self, graph):
        """
        :type graph: List[List[int]]
        :rtype: bool
        """
        e = collections.defaultdict(set)
        for i in range(len(graph)):
            for node in graph[i]:
                e[i].add(node)
        
        opposite = []
        while opposite or e:
            # if any other cluster, init to that
            s = set(opposite) if opposite else set([e.items()[0][0]])
            for v in s:
                for pair in e[v]:
                    if pair in s:
                        return False
                    e[pair].discard(v)
                    if len(e[pair]) == 0:
                        del e[pair]
                    
            opposite = []
            for v in s:
                for pair in e[v]:
                    opposite.append(pair)
            del e[v]
            
        return True
                