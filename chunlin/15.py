class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if not nums:
            return list()
        nums.sort()
        result = list()
        for i in range(len(nums)-2):
            if i and nums[i] == nums[i - 1]:        # dedup, forgot
                continue
            target = -nums[i]
            start = i + 1
            end = len(nums) - 1
            while start < end:
                if nums[start] + nums[end] < target:
                    start += 1
                elif nums[start] + nums[end] > target:
                    end -= 1
                else:
                    triple = [nums[i], nums[start], nums[end]]
                    # if triple not in result:      # TLE
                    result.append(triple)
                    start += 1              # forgot, TLE
                    end -= 1
                    while start < end and nums[start] == nums[start - 1]:   # dedup, forgot
                        start += 1
                    while start < end and nums[end] == nums[end + 1]:
                        end -= 1
        return result
        
        
        # WA: [0,0,0,0] -> [[0,0,0]]
        # WA: [-2,0,1,1,2]
