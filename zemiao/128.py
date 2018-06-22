class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        leftLen, rightLen = {}, {}
        ans = 0
        for x in nums:
            if x in leftLen:
                # x is influenced by x-1,x+1 but won't update x-1,x+1 if they're in the middle
                continue
            leftLen[x] = leftLen[x-1]+1 if x-1 in leftLen else 0
            rightLen[x] = rightLen[x+1]+1 if x+1 in rightLen else 0
            if x-1 in leftLen:
                rightLen[x-leftLen[x]] = leftLen[x]+rightLen[x]
            if x+1 in rightLen:
                leftLen[x+rightLen[x]] = leftLen[x]+rightLen[x]
            ans = max(ans, leftLen[x]+rightLen[x]+1)        

        return ans