class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: void Do not return anything, modify nums1 in-place instead.
        """
        i,j = m+n-1,m-1
        for x in reversed(nums2):
          while j>=0 and x<=nums1[j]:
            nums1[i] = nums1[j]
            j -= 1
            i -= 1
          nums1[i] = x
          i -= 1