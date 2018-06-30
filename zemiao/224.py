class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        ops, nums = collections.deque(), collections.deque()
        i = 0
        s = s.replace(' ',"")
        while i < len(s):
            c = s[i]
            if ord('0') <= ord(c) <= ord('9'):
                while i+1<len(s) and ord('0') <= ord(s[i+1]) <= ord('9'):
                    i += 1
                    c = c+s[i]
                nums.append(int(c))
            elif c in ['+','-']:
                ops.append(c)
                if ord('0') <= ord(s[i+1]) <= ord('9'):
                    i += 1
                    c = s[i]
                    while i+1<len(s) and ord('0') <= ord(s[i+1]) <= ord('9'):
                        i += 1
                        c = c+s[i]
                    b = int(c)
                    nums.append(b)
            elif c == ')':
                    op = ops.pop()
                    temp = []
                    while op != '(':
                        a = nums.pop()
                        temp.append(a if op == '+' else -a)
                        op = ops.pop()
                    if temp:
                        nums.append(nums.pop()+sum(temp))
            else:
                ops.append(c)
            i += 1

        ans = nums.popleft()
        while ops:
            op = ops.popleft()
            a = nums.popleft()
            ans = ans+a if op == '+' else ans-a
        return ans
