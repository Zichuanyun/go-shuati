class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        ans = []
        n = len(nums)
        
        def dfs(begin):
            if begin == n:
                ans.append(list(nums))
                
            for i in range(begin,n):
                nums[i], nums[begin] = nums[begin], nums[i]
                dfs(begin+1)
                nums[i], nums[begin] = nums[begin], nums[i]
        
        dfs(0)
        return ans