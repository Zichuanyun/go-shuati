class Solution(object):
    def numberOfArithmeticSlices(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        # dp[i][d]: count of slices of delta d that ends with A[i]
        from collections import defaultdict
        total = 0
        dp = [defaultdict(int) for item in A]
        for i in range(len(A)):
            for j in range(i):
                dp[i][A[i] - A[j]] += 1
                if A[i]-A[j] in dp[j]:
                    dp[i][A[i] - A[j]] += dp[j][A[i]-A[j]]
                    total += dp[j][A[i]-A[j]]
        return total