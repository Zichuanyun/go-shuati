class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        mask = 0
        
        # duplicates neutralize to 0 when XoR all
        for i in nums:
            mask ^= i
        
        # get last bit of 1 from mask
        diffbit = mask & -mask
        
        ans1, ans2 = 0, 0
        for i in nums:
            if i & diffbit:
                ans1 ^= i
            else:
                ans2 ^= i
            
        return [ans1, ans2]
            