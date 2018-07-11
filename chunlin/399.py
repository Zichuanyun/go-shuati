class Solution(object):
    def calcEquation(self, equations, values, queries):
        """
        :type equations: List[List[str]]
        :type values: List[float]
        :type queries: List[List[str]]
        :rtype: List[float]
        """
        graph = dict()
        results = list()
        for i in range(len(equations)):
            equation = equations[i]
            value = values[i]
            if equation[0] not in graph:
                graph[equation[0]] = list()
            if equation[1] not in graph:
                graph[equation[1]] = list()
            graph[equation[0]].append(tuple((equation[1], value)))
            graph[equation[1]].append(tuple((equation[0], 1.0 / value)))
        for query in queries:
            visited = set()
            if query[0] not in graph or query[1] not in graph:
                results.append(-1.0)
                continue
            temp = self.helper(query[0], query[1], graph, visited, 1.0)
            if temp == 0.0:
                results.append(-1.0)
            else:
                results.append(temp)
        return results
    
    def helper(self, start, end, graph, visited, value):
        if start in visited:
            return 0.0
        if start == end:
            return value
        visited.add(start)
        for tup in graph[start]:
            next_start = tup[0]
            next_val = tup[1]
            result = self.helper(next_start, end, graph, visited, value * next_val);
            if result != 0.0:
                return result
        visited.remove(start)
        return 0.0
    # takeaway: function definition inside Python class
    # first argument: self, but no need to add self when calling
    # calling function: self.helper
    
    # remember to add hashset
    # notice: hashset need to be renewed for every query, 
    # WA first time because it's defined outside of for loop
                
        
