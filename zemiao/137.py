class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ans = 0
        for i in range(32):
            
            # After this step, bit i of ans will be count(where bit i is 1) %3
            count = 0
            for a in nums:
                if ((a >> i) & 1):
                    count+=1
            ans |= ((count%3) << i)
            
        return self.convert(ans)
    
    '''converts >32bit signed ans into 32bit signed,
    x >= 2**31 means the 1st 32-bit is 1, a neg number.
    neg number is stored as flip(pos)+1
    '''
    def convert(self,x):
        if x >= 2**31:
            x -= 2**32
        return x