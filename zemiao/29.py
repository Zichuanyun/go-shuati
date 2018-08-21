class Solution(object):
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        def dividePositive(x,y):
            if x < y:
                return 0
            
            s,i = y,1
            while s <= x:
                if s == x:
                    return i
                
                if s+s > x:
                    return i+dividePositive(x-s,y)
                
                s,i = s+s,i+i
        
        res = 0
        if dividend > 0 and divisor < 0:
            res = -dividePositive(dividend,-divisor)
        elif dividend < 0 and divisor > 0:
            res = -dividePositive(-dividend,divisor)
        elif dividend < 0 and divisor < 0:
            res = dividePositive(-dividend,-divisor)
        else:
            res = dividePositive(dividend,divisor)
        return min(res,2**31-1)