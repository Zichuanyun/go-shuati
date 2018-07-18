"""
The knows API is already defined for you.
@param a, person a
@param b, person b
@return a boolean, whether a knows b
you can call Celebrity.knows(a, b)
"""


class Solution:
  # @param {int} n a party with n people
  # @return {int} the celebrity's label or -1
  def findCelebrity(self, n):
    if n==1:
      return 0
      
    candidates = set()
    for i in range(n):
      candidates.add(i)
    i = 0
    while(candidates):
      if len(candidates) == 1:
        break
      for j in candidates:
        if i == j:
          continue
        if Celebrity.knows(i,j):
          candidates.discard(i)
          i = j
        else:
          candidates.discard(j)
        break

    for j in range(n):
      if i==j:
        continue
      if Celebrity.knows(i,j) or not Celebrity.knows(j,i):
        return -1
      return i
