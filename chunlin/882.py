class Solution(object):

    def __init__(self, rects):
        """
        :type rects: List[List[int]]
        """
        self.rects = rects
        self.sumpoints = []
        cur_sum = 0
        for rect in rects:
            area = (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1)
            cur_sum += area
            self.sumpoints.append(cur_sum)
        

    def pick(self):
        """
        :rtype: List[int]
        """
        choice = random.randint(1, self.sumpoints[-1])
        index = bisect.bisect_left(self.sumpoints, choice)
        # sumpoint = bisect.bisect_left(self.sumpoints, choice)
        # index = self.sumpoints.index(sumpoint)
        (a, b, c, d) = self.rects[index]
        return [random.randint(a, c), random.randint(b, d)]


# Your Solution object will be instantiated and called as such:
# obj = Solution(rects)
# param_1 = obj.pick()
