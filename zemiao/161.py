class Solution:
    """
    @param s: a string
    @param t: a string
    @return: true if they are both one edit distance apart or false
    """
    def isOneEditDistance(self, s, t):
      m,n = len(s),len(t)
      if s==t:
        return False
      if abs(m-n)>1:
        return False
      i,j=0,0
      d = 0
      while i<m and j<n:
        if s[i]==t[j]:
          i,j = i+1,j+1
          continue
        return s[i+1:]==t[j+1:] or s[i+1:]==t[j:] or s[i:]==t[j+1:]

      return True