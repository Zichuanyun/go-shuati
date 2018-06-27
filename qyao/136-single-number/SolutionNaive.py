class Solution:
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        appeared_once = set()
        appeared_more_than_once = set()

        for num in nums:
            if num in appeared_more_than_once:
                pass
            elif num in appeared_once:
                appeared_once.remove(num)
            else:
                appeared_once.add(num)

        return list(appeared_once)[0]

