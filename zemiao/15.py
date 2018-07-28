class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        res = []
        n = len(nums)
        for i in range(n-2):
          if i>0 and nums[i-1]==nums[i]:
            continue
            
          if -nums[i]<2*nums[i+1] or -nums[i]>2*nums[n-1]:
            continue
            
          # Two sum
          l,r = i+1, n-1
          while l<r:
            if l>i+1 and nums[l-1]==nums[l]:
              l += 1
              continue
              
            if r<n-1 and nums[r]==nums[r+1]:
              r -= 1
              continue
            
            if nums[l]+nums[r] == -nums[i]:
              res.append([nums[i],nums[l],nums[r]])
              l,r = l+1,r-1
            elif nums[l]+nums[r] < -nums[i]:
              l += 1
            else:
              r -= 1
            
        return res
        
# --------------- non sorting ---------------------        

class Solution2(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        if not nums:
          return res
        
        map = collections.defaultdict(int)
        n = len(nums)
        for x in nums:
          map[x] += 1
        
        firstNum = set()
        for i in range(n):
          x = nums[i]
          map[x] -= 1
          if x in firstNum:
            # Makes sure every 2sum is searching for different target, i.e. -x
            continue
          
          visited = set()
          for j in range(i+1,n):
            y = nums[j]
            if y in visited:
              # Makes sure 2sum result contains no duplicated pairs.
              continue
              
            if y in firstNum or -x-y in firstNum:
              # Duplicated, because every triplet including previous firstNum was already explored.
              continue
              
            if -x == y+y:
              if map[y]>=2:
                visited.add(y)
                res.append([x,y,y])
            elif map[-x-y] > 0:
              visited.add(y)
              visited.add(-x-y)
              res.append([x,y,-x-y])
          
          firstNum.add(x)

        return res