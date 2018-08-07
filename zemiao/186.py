class Solution:
    """
    @param str: a string
    @return: return a string
    """
    def reverseWords(self, str):
      begin, end = 0,len(str)
      l,r = begin,end-1
      while l<end and str[l]!=' ':
        l += 1
      while r>=0 and str[r]!=' ':
        r -= 1
      if l>r:
        return str
      if l==r:
        return str[r+1:end]+' '+str[begin:l]
      return str[r+1:end]+' '+self.reverseWords(str[l+1:r])+' '+str[begin:l]
