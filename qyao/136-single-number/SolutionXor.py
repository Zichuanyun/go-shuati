class Solution:
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        """
        Using the properties of XOR:
        as x XOR x = 0, 0 XOR x = x and the distributivity / commutativity (just like mulitplication)
        By XORing everything together, those numbers that appeared twice will cancel itself out, leaving on the digit that appeared one time
        """
        
        result = 0
        for i in nums:
            result ^= i
        
        return result
