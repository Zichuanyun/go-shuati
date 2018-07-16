class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        i,j = len(a)-1,len(b)-1
        k = None
        res = ""
        while i>=0 or j>=0 or k:
          x,y,z=0,0,0
          if i>=0:
            x = 1 if a[i]=='1' else 0
            i -= 1
          if j>=0:
            y = 1 if b[j]=='1' else 0
            j -= 1
          if k:
            z = 1
            k = None
          res += str((x+y+z)%2)
          k = 1 if (x+y+z)//2 else None

        return res[::-1]