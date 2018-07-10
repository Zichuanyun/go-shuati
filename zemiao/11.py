class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        ans = 0
        l, r = 0, len(height)-1
        while l < r:
            ans = max(ans, (r-l)*min(height[l], height[r]))
            if height[l] < height[r]:
                l += 1
            else:
                r -= 1
        return ans