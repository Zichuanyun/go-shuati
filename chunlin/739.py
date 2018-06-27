class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        stack = []
        days = [0] * len(temperatures)
        idx = 0
        for t in temperatures:
            if not stack or (stack and t <= stack[-1][0]): # empty
                stack.append(tuple((t, idx)))
            else:   # t > stack[-1]
                while stack and t > stack[-1][0]:
                    (temp, day) = stack.pop()
                    days[day] = idx - day
                stack.append(tuple((t, idx)))
            idx += 1
        return days
                
                
