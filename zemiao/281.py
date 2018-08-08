class ZigzagIterator:
    """
    @param: v1: A 1d vector
    @param: v2: A 1d vector
    """
    def __init__(self, v1, v2):
        self.index1 = 0
        self.index2 = 0
        self.v1 = v1
        self.v2 = v2
        self.outputIndex1 = True

    """
    @return: An integer
    """
    def next(self):
      outputIndex1 = self.outputIndex1
      self.outputIndex1 = not self.outputIndex1
      if outputIndex1 and self.index1<len(self.v1):
          self.index1 += 1
          return self.v1[self.index1-1]
      elif not outputIndex1 and self.index2<len(self.v2):
          self.index2 += 1
          return self.v2[self.index2-1]
      elif self.hasNext():
        return self.next()
      return -1

    """
    @return: True if has next
    """
    def hasNext(self):
        return self.index1<len(self.v1) or self.index2<len(self.v2)

# Your ZigzagIterator object will be instantiated and called as such:
# solution, result = ZigzagIterator(v1, v2), []
# while solution.hasNext(): result.append(solution.next())
# Output result