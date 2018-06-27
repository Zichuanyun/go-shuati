class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        temps = [0]*101
        ans = []
        for i in reversed(range(len(temperatures))):
            found = 2**30
            tempToday = temperatures[i]
            for j in range(tempToday+1, 101):
                if temps[j] != 0:
                    found = min(found, temps[j]-i)
            ans.append(0 if found == 2**30 else found)
            temps[tempToday] = i
        
        return list(reversed(ans))