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
            else:
                ops.append(c)
            i += 1
        
        _ops, _nums = collections.deque(), collections.deque()
        _nums.append(nums.popleft())
        while ops:
            op = ops.popleft()
            if op in ['*','/']:
                a = _nums.pop()
                b = nums.popleft()
                _nums.append(a*b if op == '*' else a/b)
            else:
                _ops.append(op)
                _nums.append(nums.popleft())
        
        ans = _nums.popleft()
        while _ops:
            op = _ops.popleft()
            a = _nums.popleft()
            ans = ans+a if op == '+' else ans-a
        return ans
                