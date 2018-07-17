class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        result = collections.defaultdict(list)
        for s in strs:
            result[tuple(sorted(s))].append(s)
        return result.values()
