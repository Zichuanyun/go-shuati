class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x == 0 or x == 1:       # forgot edge case
            return x
        start = 0
        end = x
        while start + 1 < end:
            mid = start + (end - start) / 2
            if mid * mid > x:
                end = mid
            elif mid * mid < x:
                start = mid
            else:
                return mid
        if end * end <= x:
            return end
        return start
        # if start * start == x:
            # return start
        # return end
