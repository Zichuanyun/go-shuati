class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        appear = {}
        for i in nums:
            if i in appear:
                del appear[i]
            else:
                appear[i] = True
                
        for k in appear:
            return k