class Solution(object):
    def findDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        l, r = 1, n-1
        while l<=r:
            if l+1 >= r:
                count = sum([1 if i <= l else 0 for i in nums])
                return l if count > l else r
            mid = l + (r-l)/2
            count = sum([1 if i <= mid else 0 for i in nums])
            if count <= mid-1+1:
                l = mid
            else:
                r = mid
                