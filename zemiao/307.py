class NumArray(object):
    # segment tree (stored in an array)
  
    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        self.n = len(nums)
        self.dp = collections.defaultdict(int)
        
        def construct(i,j):
          if i>j:
            return
          if i==j:
            self.dp[(i,j)] = nums[i]
            return
          mid = i+(j-i)/2
          construct(i,mid)
          construct(mid+1,j)
          self.dp[(i,j)] = self.dp[(i,mid)]+self.dp[(mid+1,j)]
        
        construct(0,self.n-1)

    def update(self, i, val):
        """
        :type i: int
        :type val: int
        :rtype: void
        """
        def updateDP(a,b,i,val):
          if i>b or i<a:
            return
          if a == b:
            self.dp[(a,b)] = val
            return
          mid = a + (b-a)/2
          if i <= mid:
            updateDP(a,mid,i,val)
          else:
            updateDP(mid+1,b,i,val)
          self.dp[(a,b)] = self.dp[(a,mid)]+self.dp[(mid+1,b)]
        
        updateDP(0,self.n-1,i,val)

    def sumRange(self, i, j):
        """
        :type i: int
        :type j: int
        :rtype: int
        """
        def sumDP(a,b,i,j):
          if (a,b) == (i,j):
            return self.dp[(a,b)]
          mid = a+(b-a)/2
          if i > mid:
            return sumDP(mid+1,b,i,j)
          elif j <= mid:
            return sumDP(a,mid,i,j)
          return sumDP(a,mid,i,mid)+sumDP(mid+1,b,mid+1,j)
        
        if i<0 or j>=self.n:
          return 0
        return sumDP(0,self.n-1,i,j)

# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# obj.update(i,val)
# param_2 = obj.sumRange(i,j)