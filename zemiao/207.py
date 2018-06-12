class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        # m[i] is a dict of {set of available course after course i}
        from collections import *
        m, require, finished = defaultdict(dict), defaultdict(dict), {}
        for pair in prerequisites:
            m[pair[1]][pair[0]] = True
            require[pair[0]][pair[1]] = True

        stack = []
        for i in range(numCourses):
            if not i in require:
                finished[i] = True
                stack += [i]
            
        while stack:
            k = stack.pop()
            for next in m[k]:
                if next in finished:
                    continue
                    
                pending = False
                for i in require[next]:
                    if not i in finished:
                        pending = True
                        break
                        
                if not pending:
                    finished[next] = True
                    stack += [next]
            
        return len(finished) == numCourses