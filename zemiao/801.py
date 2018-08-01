class Solution(object):
    def minSwap(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: int
        """
        if not A or not B:
            return 0
        
        swap, noSwap = [0,-1,-1],[0,-1,-1]
        n = len(A)
        for i in range(n):
            _swap, _noSwap = [2**32,0,0],[2**32,0,0]
            for s in [swap,noSwap]:
                if A[i]>s[1] and B[i]>s[2] and s[0]<_noSwap[0]:
                    _noSwap = [s[0],A[i],B[i]]
                if A[i]>s[2] and B[i]>s[1] and s[0]+1<_swap[0]:
                    _swap = [s[0]+1,B[i],A[i]]
            swap,noSwap = _swap, _noSwap
        return min(swap[0],noSwap[0])
