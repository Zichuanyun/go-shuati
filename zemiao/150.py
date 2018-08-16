class Solution(object):
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """
        stack = []
        ops = ['+','-','*','/']
        for t in tokens:
            if t in ops:
                y = stack.pop()
                x = stack.pop()
                if t == '+':
                    stack.append(x+y)
                elif t == '-':
                    stack.append(x-y) 
                elif t == '/':
                    d = math.trunc(float(x)/float(y))
                    stack.append(d)  
                else:
                    stack.append(x*y)
            else:
                stack.append(int(t))
        return stack.pop() if stack else 0