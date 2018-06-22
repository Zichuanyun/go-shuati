class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        ans = []
        
        for i in range(len(nums)):
            x = nums[i]
            if not ans:
                ans.append([x])
                continue
            while len(ans[0])==i:
                temp = ans.pop(0)
                for j in range(len(temp)+1):
                    if j > 0 and temp[j-1]==x:
                        break
                        # Going past the same number is duplicating, because
                        # any permutation after this was explored in the past round.
                    ans.append(temp[:j]+[x]+temp[j:])
        
        return ans