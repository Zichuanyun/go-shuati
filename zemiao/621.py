class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        map = collections.defaultdict(int)
        for c in tasks:
          map[c] += 1
        vs = [v for _,v in map.items()]
        m = max(vs)
        numM = sum([1 if v == m else 0 for v in vs])
        return max(len(tasks),(m-1)*(1+n)+numM)