class Solution(object):
    def findOrder(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: List[int]
        """
        require, permit = {}, {}
        for p in prerequisites:
            if p[0] not in require:
                require[p[0]] = {}
            if p[1] not in permit:
                permit[p[1]] = {}
            require[p[0]][p[1]] = True
            permit[p[1]][p[0]] = True
        
        ans = []
        stack = []
        for i in range(numCourses):
            if i not in require:
                ans += [i]
                stack += [i]
        
        while stack:
            c = stack.pop()
            if c not in permit:
                continue
                
            for p in permit[c]:
                del require[p][c]
                if len(require[p]) == 0:
                    ans += [p]
                    stack += [p]
                    
        return ans if len(ans)==numCourses else []
                
            