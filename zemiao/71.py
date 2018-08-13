class Solution(object):
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """
        stack = []
        names = path.split('/')
        for c in names:
          if c == "" or c == '.':
            continue
          
          if c == "..":
            if stack:
              stack.pop()
            continue
            
          stack.append(c)
            
        res = ""
        for c in stack:
          res = res + '/' + c
          
        if not stack:
          res = "/"
        
        return res