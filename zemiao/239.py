class Solution(object):
    def maxSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        if not nums:
            return []
        
        queue = collections.deque(nums[:k])
        m = max(queue)
        ans = [m]
        for i in nums[k:]:
            l = queue.popleft()
            queue.append(i)
            if l != m:
                m = max(m,i)
            else:
                m = max(queue)
            ans.append(m)
                
        return ans